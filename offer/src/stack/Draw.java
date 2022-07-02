package stack;



import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


import java.util.*;
import java.lang.Math;

public class Draw{
    public static void main(String[] args) {
        new DrawSee();
    }
}

class DrawSee extends JFrame {

    public int  boardWidth = 5;
    public Game game = new Game(boardWidth);

    public int offset = 60;
    public int geziWidth = 40;

    public Container conn;
    private Graphics jg;

    public DrawSee() {
        conn = this.getContentPane();
        setBounds(10, 10, 800, 800);
        setVisible(true);
        conn.setBackground(new Color(255,255,255));
        setLayout(null);
        setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container conn = this.getContentPane();
        JButton btn1 = new JButton("pass");
        btn1.setBounds(10,offset+geziWidth*boardWidth+10,100,30);
        conn.add(btn1);

        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                game.placePiece(-1, -1, game.curColor);
                drawState(game.curState);
            }
        });



        try {
            Thread.sleep(500);
        } catch (Exception e) {
            e.printStackTrace();
        }



        jg =  this.getGraphics();
        clearDesk();

        this.addMouseListener(new MouseAdapter() {


            public void mouseReleased(MouseEvent e) {

                int xm = e.getX(), ym = e.getY();

                float canvasX = xm - offset;
                float canvasY = ym - offset;

                int x = Math.round(canvasX / (float)geziWidth);
                int y = Math.round(canvasY / (float)geziWidth);

                if(x < 0 || x >= boardWidth || y < 0 || y >= boardWidth) {
                    return;
                }

                if(game.curState.cellMap.containsKey(game.curState.xy2idx(x,y))) {
                    return;
                }

                game.placePiece(x, y, game.curColor);

                drawState(game.curState);

            }

        });

    }

    public void clearDesk(){
        try {
            jg.setColor(new Color(255,255,255));
            jg.fillRect(0,0, 800, offset+geziWidth*boardWidth+40);
            jg.setColor(new Color(250,190,70));
            jg.fillRect(offset-geziWidth/2, offset-geziWidth/2, geziWidth*boardWidth, geziWidth*boardWidth);
            jg.setColor(Color.black);
            for(int i = 0; i < boardWidth; i ++) {
                jg.drawLine(i * geziWidth+offset,offset,i * geziWidth+offset,offset+geziWidth * (boardWidth-1));
                jg.drawLine(offset,offset+geziWidth * i,offset+geziWidth * (boardWidth-1),offset+geziWidth * i);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void drawPiece(int x,int y,int color){
        try {
            if(color == 1) {
                jg.setColor(Color.black);
            } else {
                jg.setColor(Color.white);
            }
            jg.fillArc(offset+geziWidth*x-geziWidth/2,offset+geziWidth*y-geziWidth/2,geziWidth,geziWidth,0,360);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void drawState(State state){
        try {
            clearDesk();
            HashMap<Integer, Integer> cellMap = state.cellMap;
            cellMap.forEach((idx, value)->{
                int xy[] = game.curState.idx2xy(idx);
                drawPiece(xy[0],xy[1],cellMap.get(idx));
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.drawInfo();
    }

    public void drawInfo(){
        try {
            jg.setColor(new Color(0,0,0));
            String white = "white:(" + game.curState.lastMove.x + "," + game.curState.lastMove.y+ ")";
            jg.drawString(white, 10, offset + geziWidth*boardWidth);
            String rate = "rate: " + (float)game.node.Q/(float)game.node.N;
            jg.drawString(rate, 10, offset + geziWidth*boardWidth + 20);

            if(game.winColor!=0){
                String winColor = "winColor: " + game.winColor;
                jg.drawString(winColor, 10+100, offset + geziWidth*boardWidth);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

class Game{
    public int curColor;
    public int boardWidth;
    public State curState;
    public Node node;
    public int winColor = 0;

    Game(int boardWidth) {
        this.curColor = 1;
        this.boardWidth = boardWidth;
        this.curState = new State(this.boardWidth, null);
        this.curState.lastMove = new Cell(-1,-1,-1,null,null,this.curState,this.curState.xy2idx(-1,-1));
        this.node = new Node(null,this.curState);
    }

    public void placePiece(int x, int y, int color){

        // State state = this.checkPiece(x,y,color);
        // if(state.result>0){
        // 	this.curState = state;
        // 	this.curColor = -this.curColor;
        // }

        if(color==1){
            State state = this.checkPiece(x,y,color);
            if(state.result>0){

                if(state.lastMove.x == -1){
                    if(this.curState.lastMove.x == -1){
                        this.winColor = this.node.getWinColor(this.curState);
                        return;
                    }
                }

                this.curState = state;
                this.curColor = -this.curColor;

                //ai
                Node node = this.node.getChild(x,y);
                if(node==null){
                    node = new Node(null,this.curState);
                }
                for(int i=0; i<10000; i++){
                    node.runOnce();
                }
                Node bestChild = node.getMaxNChild();
                // Node bestChild = node.getMaxRateChild();
                if(bestChild!=null){

                    if(bestChild.state.lastMove.x == -1){
                        if(this.curState.lastMove.x == -1){
                            this.winColor = this.node.getWinColor(this.curState);
                        }
                    }

                    this.curState = bestChild.state;
                    this.curColor = -this.curColor;
                    this.node = bestChild;


                }

            }
        }

    }

    public State checkPiece(int x, int y, int color){
        State state = this.curState.clone();

        if(x!=-1){
            int valid = state.placePiece(x,y,color);
            state.result = valid;
        }else{
            state.result = 1;
            int idx = state.xy2idx(x, y);
            state.lastMove = new Cell(x,y,color,null,null,state,idx);
        }

        return state;

    }

}

class Cell{

    public int x;
    public int y;
    public int color;
    public Cell head;
    public Cell next;
    public State state;
    public HashMap<Integer, Boolean> qi;
    public int idx;

    Cell(int x, int y, int color, Cell head, Cell next, State state, int idx) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.head = head;
        this.next = next;
        this.state = state;
        this.qi = new HashMap<Integer, Boolean>();
        this.idx = idx;

        this.initQi();
    }

    void initQi(){
        int x = this.x;
        int y = this.y;
        if(y-1>=0){
            int idx = this.state.xy2idx(x,y-1);
            if(!this.state.cellMap.containsKey(idx)){
                this.qi.put(idx, true);
            }
        }
        if(y+1<this.state.boardWidth){
            int idx = this.state.xy2idx(x,y+1);
            if(!this.state.cellMap.containsKey(idx)){
                this.qi.put(idx, true);
            }
        }
        if(x-1>=0){
            int idx = this.state.xy2idx(x-1,y);
            if(!this.state.cellMap.containsKey(idx)){
                this.qi.put(idx, true);
            }
        }
        if(x+1<this.state.boardWidth){
            int idx = this.state.xy2idx(x+1,y);
            if(!this.state.cellMap.containsKey(idx)){
                this.qi.put(idx, true);
            }
        }

    }

    public boolean mergeBlock(Cell cell2){

        boolean merged = false;

        for (Map.Entry<Integer, Boolean> entry : cell2.qi.entrySet()) {
            int idx2 = entry.getKey();

            if(idx2 == this.idx){
                Cell cell = this;
                while(cell.next!=null){
                    cell = cell.next;
                }
                cell.next = cell2;

                merged = true;
                break;
            }
        }

        if(merged){
            cell2.qi.remove(this.idx);
            this.qi.forEach((idx, value2) -> {
                cell2.qi.put(idx, true);
            });
            this.qi = cell2.qi;
        }

        return merged;

    }

    public boolean deleteQi(Cell cell2){

        boolean deleted = false;

        int deleteIdx = 0;
        for (Map.Entry<Integer, Boolean> entry : this.qi.entrySet()) {
            int idx = entry.getKey();
            if(idx == cell2.idx){
                deleteIdx = idx;
                deleted = true;
                break;
            }
        }
        if(deleted){
            this.qi.remove(deleteIdx);
        }

        return deleted;
    }

    public void addQi(Cell cell3){

        Cell cell2 = cell3;
        do{
            Cell cell = this;
            do{
                if(cell.idx-this.state.boardWidth == cell2.idx || cell.idx+this.state.boardWidth == cell2.idx || cell.x>0&&cell.idx-1 == cell2.idx || cell.x<this.state.boardWidth-1&&cell.idx+1 == cell2.idx){
                    this.qi.put(cell2.idx, true);
                    break;
                }
                cell = cell.next;
            }while(cell!=null);
            cell2 = cell2.next;
        }while(cell2!=null);

    }

    public int getQiCount(){
        return this.qi.size();
    }

    public int getCount(){

        int count = 1;
        Cell cell = this;
        while(cell.next!=null){
            count ++;
            cell = cell.next;
        }
        return count;
    }

}

class State{
    public HashMap<Integer, Integer>  cellMap;
    public ArrayList<Cell> blocks;
    public int boardWidth;
    public Cell lastMove;
    public Cell jie;
    public int result;

    State(int boardWidth, Cell lastMove) {
        this.cellMap = new HashMap<Integer, Integer>();
        this.blocks = new ArrayList<Cell>();
        this.boardWidth = boardWidth;
        this.lastMove = lastMove;
        this.jie = null;
    }

    public int xy2idx(int x, int y){
        return y*this.boardWidth+x;
    }

    public int[] idx2xy(int idx){
        int x = idx%this.boardWidth;
        int y = (idx-x)/this.boardWidth;
        return new int[]{x,y};
    }

    public State clone(){
        State state = new State(this.boardWidth,this.lastMove);
        state.jie = this.jie;

        HashMap<Integer, Integer> cellMap = new HashMap<Integer, Integer>();
        this.cellMap.forEach((key, value) -> {
            cellMap.put(key, value);
        });
        state.cellMap = cellMap;

        ArrayList<Cell> blocks = new ArrayList<Cell>();
        for(int i=0; i<this.blocks.size(); i++){
            Cell head = this.blocks.get(i);
            Cell head2 = new Cell(head.x, head.y, head.color, null, null, state, head.idx);

            HashMap<Integer, Boolean> qi = new HashMap<Integer, Boolean>();
            head.qi.forEach((key, value) -> {
                qi.put(key,value);
            });
            head2.qi = qi;

            Cell head3 = head2;
            while(head.next!=null){
                head = head.next;
                Cell child2 = new Cell(head.x, head.y, head.color, null, null, state, head.idx);
                head3.next = child2;
                head3 = child2;
            }

            blocks.add(head2);
        }
        state.blocks = blocks;

        return state;

    }

    public State checkPiece(int x,int y,int color){
        State state = this.clone();
        int result = state.placePiece(x,y,color);
        state.result = result;
        return state;
    }

    public int placePiece(int x,int y,int color){

        int idx = this.xy2idx(x,y);
        Cell cell = new Cell(x,y,color,null,null,this,idx);

        this.cellMap.put(idx,color);

        //合并
        for(int i = 0; i < this.blocks.size(); i++) {

            if(this.blocks.get(i).color != color) {
                continue;
            }

            boolean merge = cell.mergeBlock(this.blocks.get(i));
            if(merge){
                this.blocks.remove(i);
                i--;
            }
        }

        this.blocks.add(cell);

        Cell jie = null;
        //判断提
        boolean hasKill = false;
        for(int i = 0; i < this.blocks.size(); i++) {
            if(this.blocks.get(i).color == color) {
                continue;
            }

            boolean del = this.blocks.get(i).deleteQi(cell);
            if(del){
                int qiCount = this.blocks.get(i).getQiCount();
                if(qiCount == 0) {

                    int ziCount = this.blocks.get(i).getCount();

                    //jie
                    if(this.jie!=null){
                        if(cell.idx == this.jie.idx){

                            if(ziCount==1){
                                return 0;
                            }
                        }
                    }

                    hasKill = true;

                    if(ziCount==1){
                        jie = this.blocks.get(i);
                    }

                    //加气
                    for(int j = 0; j < this.blocks.size(); j++) {

                        if(this.blocks.get(j).color != color) {
                            continue;
                        }

                        this.blocks.get(j).addQi(this.blocks.get(i));
                    }

                    Cell cellKilled = this.blocks.get(i);
                    do{
                        this.cellMap.remove(cellKilled.idx);
                        cellKilled = cellKilled.next;
                    }while(cellKilled!=null);

                    this.blocks.remove(i);
                    i--;
                }
            }

        }

        int cellQi = cell.getQiCount();
        boolean hasQi = cellQi>0;

        if(!hasKill && !hasQi){
            return 0;
        }else{
            this.lastMove = cell;
            this.jie = jie;

            int result = 1;
            if(!hasKill){
                boolean fillEye = this.checkEye(cell);
                if(fillEye){
                    result = 2;
                }else{
                    if(cellQi == 1){
                        result = 3;
                    }
                }

            }

            return result;
        }

    }

    public boolean checkEye(Cell cell){
        int x = cell.x;
        int y = cell.y;
        int color = cell.color;

        if(y-1>=0){
            int idx = this.xy2idx(x,y-1);
            if(!this.cellMap.containsKey(idx) || this.cellMap.get(idx)!=color){
                return false;
            }
        }
        if(y+1<this.boardWidth){
            int idx = this.xy2idx(x,y+1);
            if(!this.cellMap.containsKey(idx) || this.cellMap.get(idx)!=color){
                return false;
            }
        }
        if(x-1>=0){
            int idx = this.xy2idx(x-1,y);
            if(!this.cellMap.containsKey(idx) || this.cellMap.get(idx)!=color){
                return false;
            }
        }
        if(x+1<this.boardWidth){
            int idx = this.xy2idx(x+1,y);
            if(!this.cellMap.containsKey(idx) || this.cellMap.get(idx)!=color){
                return false;
            }
        }

        int corner = 0;
        int enemy = 0;
        if(x-1>=0){
            if(y-1>=0){
                corner++;
                int idx = this.xy2idx(x-1,y-1);
                if(this.cellMap.containsKey(idx) && this.cellMap.get(idx)==-color){
                    enemy++;
                }
            }
            if(y+1<this.boardWidth){
                corner++;
                int idx = this.xy2idx(x-1,y+1);
                if(this.cellMap.containsKey(idx) && this.cellMap.get(idx)==-color){
                    enemy++;
                }
            }
        }
        if(x+1<this.boardWidth){
            if(y-1>=0){
                corner++;
                int idx = this.xy2idx(x+1,y-1);
                if(this.cellMap.containsKey(idx) && this.cellMap.get(idx)==-color){
                    enemy++;
                }
            }
            if(y+1<this.boardWidth){
                corner++;
                int idx = this.xy2idx(x+1,y+1);
                if(this.cellMap.containsKey(idx) && this.cellMap.get(idx)==-color){
                    enemy++;
                }
            }
        }

        if((float)enemy/(float)corner>=0.5){
            return false;
        }else{
            return true;
        }

    }

}

class Node{
    public Node father;
    public float ucb;
    public int Q;
    public int N;
    public ArrayList<Node> children;
    public Node maxUCBChild;
    public State state;
    public boolean end;
    public int winColor = 0;



    Node(Node father, State state){
        this.father = father;
        this.ucb = Float.MAX_VALUE;
        this.Q = 0;
        this.N = 0;
        this.children = new ArrayList<Node>();
        this.maxUCBChild = null;
        this.state = state;
        this.end = false;
    }

    public void runOnce(){
        Node selectedNode = this;

        while(selectedNode.children.size()>0){
            selectedNode = selectedNode.setMaxUCBChild();
        }

        if(selectedNode.N>0){
            if(selectedNode.end){
                this.backpropagation(selectedNode.winColor, selectedNode);
                return;
            }
            selectedNode.createChildren();
            selectedNode = selectedNode.children.get(0);
        }

        if(selectedNode.end){
            if(selectedNode.winColor==0){
                selectedNode.winColor = this.getWinColor(selectedNode.state);
            }
            this.backpropagation(selectedNode.winColor, selectedNode);
            return;
        }

        int winColor = selectedNode.simulate();
        Node node = selectedNode;

        this.backpropagation(winColor, node);

    }

    public void backpropagation(int winColor, Node node){
        do{
            node.updateQN(winColor);
            node = node.father;
        }while(node!=null);
    }

    public void updateQN(int winColor){
        this.N++;
        if(winColor==this.state.lastMove.color){
            this.Q++;
        }
    }

    public Node setMaxUCBChild(){
        float max = -Float.MAX_VALUE;
        for(int idx=0; idx<this.children.size(); idx++){
            float ucb = this.children.get(idx).updateUCB();
            if(ucb>max){
                max = ucb;
                this.maxUCBChild = this.children.get(idx);
            }
        }
        return this.maxUCBChild;
    }

    public Node getMaxNChild(){
        int max = -Integer.MAX_VALUE;
        Node best=null;
        for(int idx=0; idx<this.children.size(); idx++){
            int N = this.children.get(idx).N;
            if(N>max){
                max = N;
                best = this.children.get(idx);
            }else if(N==max){
                if(this.children.get(idx).Q>best.Q){
                    max = N;
                    best = this.children.get(idx);
                }
            }
        }
        return best;
    }

    public Node getMaxRateChild(){
        float max = -Float.MAX_VALUE;
        Node best=null;
        for(int idx=0; idx<this.children.size(); idx++){
            float rate = (float)this.children.get(idx).Q/(float)this.children.get(idx).N;
            if(rate>max){
                max = rate;
                best = this.children.get(idx);
            }
        }
        return best;
    }

    public void createChildren(){
        int color = -this.state.lastMove.color;
        int normalCount = 0;
        for(int x=0; x<this.state.boardWidth; x++){
            for(int y=0; y<this.state.boardWidth; y++){
                int idx = this.state.xy2idx(x,y);
                if(!this.state.cellMap.containsKey(idx)){
                    State state = this.state.checkPiece(x,y,color);
                    if(state.result>0){
                        Node node = new Node(this,state);
                        this.children.add(node);
                    }
                    if(state.result == 1){
                        normalCount++;
                    }

                }
            }
        }

        if(normalCount==0){
            int idx = this.state.xy2idx(-1,-1);
            State state1 = this.state.clone();
            Cell cell = new Cell(-1, -1, color, null, null, state1, idx);
            state1.lastMove = cell;
            Node node = new Node(this,state1);
            this.children.add(node);

            if(this.state.lastMove.x==-1){
                node.end = true;
            }
        }

    }

    public int simulate(){
        boolean end = false;
        State state = this.state;
        int lastX = state.lastMove.x;
        do{
            int color = -state.lastMove.color;
            ArrayList<State> normalMove = new ArrayList<State>();
            ArrayList<State> oneQiMove = new ArrayList<State>();
            for(int x=0; x<state.boardWidth; x++){
                for(int y=0; y<state.boardWidth; y++){
                    int idx = state.xy2idx(x,y);
                    if(!state.cellMap.containsKey(idx)){
                        State checkRes = state.checkPiece(x,y,color);
                        if(checkRes.result == 1){
                            normalMove.add(checkRes);
                        }else if(checkRes.result == 3){
                            oneQiMove.add(checkRes);
                        }
                    }
                }
            }

            ArrayList<State> allMove = new ArrayList<State>();
            allMove.addAll(normalMove);
            allMove.addAll(oneQiMove);
            if(normalMove.size()==0){
                int idx = state.xy2idx(-1,-1);
                State state1 = state.clone();
                Cell cell = new Cell(-1, -1, color, null, null, state1, idx);
                state1.lastMove = cell;
                allMove.add(state1);
            }

            int selectIdx = this.getRandomInt(allMove.size());

            State selected = allMove.get(selectIdx);

            if(selected.lastMove.x == -1){
                if(lastX == -1){
                    end = true;
                }
            }
            lastX = selected.lastMove.x;

            state = selected;
        }while(!end);

        int winColor = this.getWinColor(state);

        this.winColor = winColor;
        return winColor;

    }

    public int getWinColor(State state){
        int black = 0;
        int white = 0;

        ArrayList<Cell> blocks = state.blocks;
        HashMap<Integer,Boolean> blackQi = new HashMap<Integer,Boolean>();
        HashMap<Integer,Boolean> whiteQi = new HashMap<Integer,Boolean>();
        for(int i=0; i<blocks.size(); i++){
            int ziCount = blocks.get(i).getCount();

            if(blocks.get(i).color == 1){
                black += ziCount;
                blocks.get(i).qi.forEach((idx,value)->{
                    blackQi.put(idx, value);
                });
            }else{
                white += ziCount;
                blocks.get(i).qi.forEach((idx,value)->{
                    whiteQi.put(idx, value);
                });
            }
        }
        black += blackQi.size();
        white += whiteQi.size();

        if(black>white){
            return 1;
        }else{
            return -1;
        }
    }

    public int getRandomInt(int max) {
        return (int)Math.floor(Math.random() * (float)max);
    }

    public float updateUCB(){
        if(this.N==0){
            return Float.MAX_VALUE;
        }
        this.ucb = (float) ((float)this.Q/(float)this.N + Math.sqrt(2.0*Math.log((float)this.father.N)/(float)this.N));
        return this.ucb;
    }

    public Node getChild(int x,int y){
        for(int idx=0; idx<this.children.size(); idx++){
            Cell lastMove = this.children.get(idx).state.lastMove;
            if(lastMove.x==x&&lastMove.y==y){
                return this.children.get(idx);
            }
        }
        return null;
    }
}



