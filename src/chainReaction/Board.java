package chainReaction;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static chainReaction.IntSketchBoard.g;
public class Board extends JPanel implements ActionListener{
    private  boolean isplaying=false;
    private int score,delay=8;
    private Timer timer;
    private int a[][][]=new int[10][6][2],colorA[][]= new int[10][6],x=9000,y=9000,arrx,arry;
    private Color op_colorA[][]= new Color[10][6];
    private int valarr[][]=new int[10][6];Main m=new Main();
    public int[][][] numberOfBalls=new int[10][6][2],limit=new int[10][6][2];
    public Board() {
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer= new Timer(delay,this);
        timer.start();
        sketchBoard(g);
    }
    public void print() {
        System.out.println("x is:"+x+"y is:"+y);
        arrx=(y-33)/54;
        arry=(x-9)/80;
        //t1=t1+1;
        //a[t1][1]=37+arry*80;
        //a[t1][0]=30+55*arrx;
        a[arrx][arry][1]=37+arry*80;
        a[arrx][arry][0]=30+55*arrx;
        valarr[arrx][arry]=valarr[arrx][arry]+1;
        System.out.println("arrx is:"+arrx+" arry is:"+arry+" "+"valarr is:"+valarr[arrx][arry]);
        if(colorA[arrx][arry]==0) colorA[arrx][arry]=m.chanceOf;
        if(numberOfBalls[arrx][arry][0]+numberOfBalls[arrx][arry][1]==0)numberOfBalls[arrx][arry][m.chanceOf%2]++;
        else if(numberOfBalls[arrx][arry][0]!=0) {
            if(colorA[arrx][arry]%2==0) {
                if(m.chanceOf%2==0) {
                    ++numberOfBalls[arrx][arry][0];
                }
                else
                {
                    m.chanceOf--;
                }
            }
        }
        else if(numberOfBalls[arrx][arry][1]!=0) {
            if(colorA[arrx][arry]%2==1) {
                if(m.chanceOf%2==1) {
                    ++numberOfBalls[arrx][arry][1];
                }
                else {
                    m.chanceOf--;
                }
            }
        }
    }
    public void getxy() {
        x=m.X;
        y=m.Y;
    }
    public Color color() {
        int n=m.chanceOf;
        if(n%2==0) return Color.RED;
        else return Color.GREEN;
    }
    public void something() {
        int i=0;
        for(i=0;i<10;i++) {
            for(int j=0;j<6;j++) {                                                      //generating the limit
                limit[i][j][0]=3-(((j-1)<0||(j+1)>=6)?1:0)-((i-1)<0||(i+1)>=10?1:0);
            }
        }
        i=0;
        while (isEverythingOkay(numberOfBalls))
        {
            checkLimit(numberOfBalls, limit);
            i++;
        }
        display(numberOfBalls);
    }
    public void allNull(){
        for(int i=0;i<a.length;i++) {
            for(int j=0;j<a[0].length;j++) {
                g.drawString("",a[i][j][1],a[i][j][0]);
            }
        }
    }
    public void something1() {

        int i=0;
        for(i=0;i<10;i++) {
            for(int j=0;j<6;j++) {
                limit[i][j][0]=3-(((j-1)<0||(j+1)>=6)?1:0)-((i-1)<0||(i+1)>=10?1:0);
            }
        }
        i=0;
        while (isEverythingOkay1(numberOfBalls))
        {
            checkLimit1(numberOfBalls, limit);
            i++;
        }
        display(numberOfBalls);
    }
    public void display1Ball(Graphics gr,int j,int i) {
        gr.drawString(String.valueOf(1),i,j);
        System.out.print("hkjmhgnf");
    }
    public void display(int a[][][]) {
        for(int i=0;i<10;i++){
            for(int j=0;j<6;j++){
                System.out.print(numberOfBalls[i][j][0]+"  ");
            }
            System.out.print("      ");
            for(int j=0;j<6;j++){
                System.out.print(numberOfBalls[i][j][1]+"  ");
            }
            System.out.println("");
        }
    }
    public void doSomething1(int ele) {
        int i=0,j=0,x=0,y=0;
        for(i=0;i<numberOfBalls.length;i++) {                                       //getting (i,j) coordinated of element.
            for(j=0;j<numberOfBalls[1].length;j++) {
                if(numberOfBalls[i][j][1]==ele) {
                    x=i;
                    y=j;
                    break;
                }
            }
        }
        i=x;j=y;

        //System.out.print("*****");
        if(i+1<numberOfBalls.length) {
            if(numberOfBalls[i+1][j][1]==0&&numberOfBalls[i+1][j][0]==0)numberOfBalls[i+1][j][1]++;
            else if(numberOfBalls[i+1][j][0]==0) {++numberOfBalls[i+1][j][1];}
            else {numberOfBalls[i+1][j][1]=++numberOfBalls[i+1][j][0];numberOfBalls[i+1][j][0]=0;}
            numberOfBalls[i][j][1]=0;
        }
        // System.out.print(a[i+1][j]);System.out.print("//////");
        if(i-1>=0) {
            if(numberOfBalls[i - 1][j][1]==0&&numberOfBalls[i-1][j][0]==0)numberOfBalls[i - 1][j][1]++;
            else if(numberOfBalls[i-1][j][0]==0) {++numberOfBalls[i-1][j][1];}
            else {numberOfBalls[i-1][j][1]=++numberOfBalls[i-1][j][0];numberOfBalls[i-1][j][0]=0;}
            numberOfBalls[i][j][1]=0;
        }
        //System.out.print(a[i-1][j]);
        if(j+1<numberOfBalls[0].length) {
            if(numberOfBalls[i][j+1][1]==0&&numberOfBalls[i][j+1][0]==0)numberOfBalls[i][j+1][1]++;
            else if(numberOfBalls[i][j+1][0]==0) {++numberOfBalls[i][j+1][1];}
            else {numberOfBalls[i][j+1][1]=++numberOfBalls[i][j+1][0];numberOfBalls[i][j+1][0]=0;}
            numberOfBalls[i][j][1]=0;
        }
        //System.out.print(a[i][j+1]);
        if(j-1>=0) {
            if(numberOfBalls[i][j-1][1]==0&&numberOfBalls[i][j-1][0]==0)numberOfBalls[i][j - 1][1]++;
            else if(numberOfBalls[i][j-1][0]==0) {++numberOfBalls[i][j-1][1];}
            else {numberOfBalls[i][j-1][1]=++numberOfBalls[i][j-1][0];numberOfBalls[i][j-1][0]=0;}
            numberOfBalls[i][j][1]=0;
        }
        //System.out.print(a[i][j-1]);
    }
    private void doSomething(int ele) {
        int i=0,j=0,x=0,y=0;
        for(i=0;i<numberOfBalls.length;i++) {                                       //getting (i,j) coordinated of element.
            for(j=0;j<numberOfBalls[0].length;j++) {
                if(numberOfBalls[i][j][0]==ele) {
                    x=i;
                    y=j;
                    break;
                }
            }
        }
        i=x;j=y;

        //System.out.print("*****");
        if(i+1<numberOfBalls.length) {
            if(numberOfBalls[i+1][j][0]==0&&numberOfBalls[i+1][j][1]==0)numberOfBalls[i+1][j][0]++;
            else if(numberOfBalls[i+1][j][1]==0) {++numberOfBalls[i+1][j][0];}
            else {numberOfBalls[i+1][j][0]=++numberOfBalls[i+1][j][1];numberOfBalls[i+1][j][1]=0;}
            numberOfBalls[i][j][0]=0;
        }
        // System.out.print(a[i+1][j]);System.out.print("//////");
        if(i-1>=0) {
            if(numberOfBalls[i-1][j][0]==0&&numberOfBalls[i-1][j][1]==0)numberOfBalls[i-1][j][0]++;
            else if(numberOfBalls[i-1][j][1]==0) {++numberOfBalls[i-1][j][0];}
            else {numberOfBalls[i-1][j][0]=++numberOfBalls[i-1][j][1];numberOfBalls[i-1][j][1]=0;}
            numberOfBalls[i][j][0]=0;
        }
        //System.out.print(a[i-1][j]);
        if(j+1<numberOfBalls[0].length) {
            if(numberOfBalls[i][j+1][0]==0&&numberOfBalls[i][j+1][1]==0)numberOfBalls[i][j + 1][0]++;
            else if(numberOfBalls[i][j+1][1]==0) {++numberOfBalls[i][j+1][0];}
            else {numberOfBalls[i][j+1][0]=++numberOfBalls[i][j+1][1];numberOfBalls[i][j+1][1]=0;}
            numberOfBalls[i][j][0]=0;
        }
        //System.out.print(a[i][j+1]);
        if(j-1>=0) {
            if(numberOfBalls[i][j-1][0]==0&&numberOfBalls[i][j-1][1]==0)numberOfBalls[i][j - 1][0]++;
            else if(numberOfBalls[i][j-1][1]==0) {++numberOfBalls[i][j-1][0];}
            else {numberOfBalls[i][j-1][0]=++numberOfBalls[i][j-1][1];numberOfBalls[i][j-1][1]=0;}
            numberOfBalls[i][j][0]=0;
        }




        //System.out.print(a[i][j-1]);
    }
    public void paint(Graphics graphics) {
        if (numberOfBalls[arrx][arry][0]==0||numberOfBalls[arrx][arry][1]==0) {
            sketchBoard(graphics);
            initialise(graphics);
            displayball(graphics);
            graphics.dispose();
        }
    }
    public void sketchBoard(Graphics graphics){
        graphics.setColor(Color.YELLOW);
        graphics.fillRect(0,0,getWidth(),getHeight());

        //background.
        graphics.setColor(Color.black);
        graphics.fillRect(3,3,getWidth()-6,getHeight()-6);
        //left margin
        graphics.setColor(color());
        graphics.fillRect(6,6,2,getHeight()-12);
        //right margin
        graphics.setColor(color());
        graphics.fillRect(getWidth()-8,6,2,getHeight()-12);

        //top margin
        graphics.setColor(color());
        graphics.fillRect(6,6,getWidth()-12,2);
        //bottom margin
        graphics.setColor(color());
        graphics.fillRect(6,getHeight()-8,getWidth()-12,2);
        //1st horizontal
        graphics.setColor(color());
        graphics.fillRect(6,6+(getHeight()-14)/10,getWidth()-12,2);
        //1st horizontal
        graphics.setColor(color());
        graphics.fillRect(6,6+2*(getHeight()-14)/10,getWidth()-12,2);

        //1st horizontal
        graphics.setColor(color());
        graphics.fillRect(6,6+3*(getHeight()-14)/10,getWidth()-12,2);

        //1st horizontal
        graphics.setColor(color());
        graphics.fillRect(6,6+4*(getHeight()-14)/10,getWidth()-12,2);

        //1st horizontal
        graphics.setColor(color());
        graphics.fillRect(6,6+5*(getHeight()-14)/10,getWidth()-12,2);

        //1st horizontal
        graphics.setColor(color());
        graphics.fillRect(6,6+6*(getHeight()-14)/10,getWidth()-12,2);

        //1st horizontal
        graphics.setColor(color());
        graphics.fillRect(6,6+7*(getHeight()-14)/10,getWidth()-12,2);

        //1st horizontal
        graphics.setColor(color());
        graphics.fillRect(6,6+8*(getHeight()-14)/10,getWidth()-12,2);

        //1st horizontal
        graphics.setColor(color());
        graphics.fillRect(6,6+9*(getHeight()-14)/10,getWidth()-12,2);

        //1st horizontal
        graphics.setColor(color());
        graphics.fillRect(6,6+(getHeight()-14)/10,getWidth()-12,2);
        //1st horizontal
        graphics.setColor(color());
        graphics.fillRect(6,6+(getHeight()-14)/10,getWidth()-12,2);

        //1st horizontal
        graphics.setColor(color());
        graphics.fillRect(6,6+(getHeight()-14)/10,getWidth()-12,2);

        //1st horizontal
        graphics.setColor(color());
        graphics.fillRect(6,6+(getHeight()-14)/10,getWidth()-12,2);

        //1st vertical
        graphics.setColor(color());
        graphics.fillRect(6+(getWidth()-14)/6,6,2,getHeight()-12);

        //second vertical
        graphics.setColor(color());
        graphics.fillRect(6+(getWidth()-14)/3,6,2,getHeight()-12);

        //third vertical
        graphics.setColor(color());
        graphics.fillRect(6+(getWidth()-14)/2,6,2,getHeight()-12);

        //fourth vertical
        graphics.setColor(color());
        graphics.fillRect(6+2*(getWidth()-14)/3,6,2,getHeight()-12);

        //fifth vertical
        graphics.setColor(color());
        graphics.fillRect(6+5*(getWidth()-14)/6,6,2,getHeight()-12);

        //sixth vertical
        graphics.setColor(color());
        graphics.fillRect(6+getWidth(),6,2,getHeight()-12);
        repaint();
    }
    public void initialise(Graphics graphics) {
        for(int i=0;i<10;i++) {
            for(int j=0;j<6;j++)
            {
                op_colorA[i][j]= colorA[i][j]%2==0 ? Color.GREEN:Color.RED;
                if(arry>10&&arry>10)
                    graphics.fillOval(a[arrx][arry][1], a[arrx][arry][0], 20, 20);
            }
        }
    }
    public void displayball(Graphics graphics){
        for(int i=0;i<10;i++) {
            for(int j=0;j<6;j++) {
                switch (numberOfBalls[i][j][0]==0?numberOfBalls[i][j][1]:numberOfBalls[i][j][0]){
                    case 1:graphics.setColor(op_colorA[i][j]);
                        graphics.fillOval(a[i][j][1], a[i][j][0], 20, 20);break;
                    case 2:
                        if(op_colorA[i][j]==Color.GREEN){
                            graphics.setColor(op_colorA[i][j]);
                            graphics.fillOval(a[i][j][1]-7, a[i][j][0], 20, 20);
                            graphics.setColor(new Color(0,150,0));
                            graphics.fillOval(a[i][j][1]+7, a[i][j][0], 20, 20);break;
                        }
                        else {
                                graphics.setColor(op_colorA[i][j]);
                                graphics.fillOval(a[i][j][1]-7, a[i][j][0], 20, 20);
                                graphics.setColor(new Color(150,0,0));
                                graphics.fillOval(a[i][j][1]+7, a[i][j][0], 20, 20);break;
                        }
                    case 3:
                        if(op_colorA[i][j]==Color.GREEN){
                            graphics.setColor(op_colorA[i][j]);
                            graphics.fillOval(a[i][j][1]-7, a[i][j][0]+5, 20, 20);
                            graphics.setColor(new Color(0,150,0));
                            graphics.fillOval(a[i][j][1]+7, a[i][j][0]+5, 20, 20);
                            graphics.setColor(new Color(0,175,0));
                            graphics.fillOval(a[i][j][1], a[i][j][0]-5, 20, 20);
                            break;
                        }
                        else {
                            graphics.setColor(op_colorA[i][j]);
                            graphics.fillOval(a[i][j][1]-7, a[i][j][0]+5, 20, 20);
                            graphics.setColor(new Color(150,0,0));
                            graphics.fillOval(a[i][j][1]+7, a[i][j][0]+5, 20, 20);
                            graphics.setColor(new Color(175,0,0));
                            graphics.fillOval(a[i][j][1], a[i][j][0]-5, 20, 20);
                            break;
                        }
                }
                    //display1Ball(g,a[i][j][1],a[i][j][0]);
                }
              /*  if(numberOfBalls[i][j][0]!=0) {
                    graphics.setColor(Color.RED);
                    graphics.drawString(String.valueOf(numberOfBalls[i][j][0]), a[i][j][1], a[i][j][0]);
                }
                else if(numberOfBalls[i][j][1]!=0){
                    graphics.setColor(Color.GREEN);
                    graphics.drawString(String.valueOf(numberOfBalls[i][j][1]), a[i][j][1], a[i][j][0]);
                }*/
            }
        }
    public boolean isEverythingOkay(int a[][][]) {
        int c=0;
        for(int i=0;i<a.length;i++) {
            for(int j=0;j<a[0].length;j++) {
                if(a[i][j][0]>limit[i][j][0]) ++c;
            }
        }
        return c==0?false:true;
    }
    public boolean isEverythingOkay1(int a[][][]) {
        int c=0;
        for(int i=0;i<a.length;i++) {
            for(int j=0;j<a[0].length;j++) {
                if(a[i][j][1]>limit[i][j][0]) ++c;
            }
        }
        return c==0?false:true;
    }
    public void checkLimit(int a[][][], int limit[][][]) {
        int[] prob=new int[a.length*a[0].length];
        for(int i=0;i<prob.length;i++) {
            prob[i]=0;
        }
        prob=problematicArray(a,limit);
        int k=0;
        do {
            System.out.print("array is:"+prob[k]+" ");
            k++;
        } while(prob[k]!=0);
        System.out.println();
        k=0;
        do {
            if(prob[k]!=0)
                doSomething(prob[k]);
            k++;
        }while(prob[k]!=0);
    }
    private void checkLimit1(int a[][][], int limit[][][]) {
        int[] prob=new int[a.length*a[0].length];
        for(int i=0;i<prob.length;i++) {
            prob[i]=0;
        }
        prob=problematicArray1(a,limit);
        int k=0;
        do {
            System.out.print("array is:"+prob[k]+" ");
            k++;
        } while(prob[k]!=0);
        System.out.println();
        k=0;
        do {
            if(prob[k]!=0)
                doSomething1(prob[k]);
            k++;
        }while(prob[k]!=0);
    }
    public static int[] problematicArray(int a[][][],int limit[][][]) {
        int k=-1;
        int[] prob = new int[a.length*a[0].length];
        for(int i=0;i<prob.length;i++) {
            prob[i]=0;
        }
        for (int i=0;i<a.length;i++) {
            for (int j=0;j<a[0].length;j++) {
                if(a[i][j][0]>limit[i][j][0]) prob[++k]=a[i][j][0];
            }
        }
        return prob;
    }
    public static int[] problematicArray1(int a[][][],int limit[][][]) {
        int k=-1;
        int[] prob = new int[a.length*a[0].length];
        for(int i=0;i<prob.length;i++) {
            prob[i]=0;
        }
        for (int i=0;i<a.length;i++) {
            for (int j=0;j<a[0].length;j++) {
                if(a[i][j][1]>limit[i][j][0]) prob[++k]=a[i][j][1];
            }
        }
        return prob;
    }
    @Override
    public void actionPerformed(ActionEvent e) {














































































































































    }
}