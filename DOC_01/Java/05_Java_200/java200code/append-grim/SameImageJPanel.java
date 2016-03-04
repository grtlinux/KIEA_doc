import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
public class SameImageJPanel extends JPanel implements MouseListener, ActionListener{
 private static final long serialVersionUID=122487214237L;//JAVA5
  JFrame mainf;
  GrimButton [] grim=null;
  GrimButton tempGrimButton;//mousePressed �� �ӽ� ����
  int count=0;  // ù ��° ��ư�� ������ 0 �ι�° ��ư�� ������ 1
                // ���� ���� ù ��° ��ư�� 1, �� ��° ��ư�� 2
  int iteNum=0; //�� �� ���߾�����? ���� ==stempnumber�̸� ��
  int stempnumber=12;   //�׸��� � �����?
  int speed=1000;
  //----------------------  GUI  -------------------------//
  JMenuBar jMenuBar1 = new JMenuBar();
  JMenu jMenuFile = new JMenu("File");
  JMenuItem jMenuFileExit = new JMenuItem("Exit");
  JMenu jMenuHelp = new JMenu("Help");
  JMenuItem jMenuHelpAbout = new JMenuItem("About");
  BorderLayout borderLayout1 = new BorderLayout();
  JPanel mainp=new JPanel();
  JMenuItem jMenuItem1 = new JMenuItem("Start");
  JMenu jMenu1 = new JMenu("Steps");
  JMenuItem jMenuItem2 = new JMenuItem("1");
  JMenuItem jMenuItem3 = new JMenuItem("2");
  JMenuItem jMenuItem4 = new JMenuItem("3");
  JMenuItem jMenuItem5 = new JMenuItem("4");
  JMenu jMenu2 = new JMenu("Speed");
  JMenuItem jMenuItem6 = new JMenuItem("1");
  JMenuItem jMenuItem7 = new JMenuItem("2");
  JMenuItem jMenuItem8 = new JMenuItem("3");
  JMenuItem jMenuItem9 = new JMenuItem("4");
  //Construct the frame
  public SameImageJPanel(JFrame mainf) {
	this.mainf=mainf;
    inits();
  }
  //Component initialization
  private void inits() {
    mainf.setSize(new Dimension(GrimUtil.WIDTH*4,GrimUtil.HEIGHT*3+GrimUtil.YSPACE));
    this.setLayout(borderLayout1);
    mainf.setTitle("���� �׸� ���߱�");
    jMenuItem1.setToolTipText("������ ������ �� ����Ѵ�.");
    jMenuFile.add(jMenuItem1);
    jMenuFile.add(jMenuFileExit);
    jMenuHelp.add(jMenuHelpAbout);
    jMenuBar1.add(jMenuFile);
    jMenuBar1.add(jMenuHelp);
    jMenuBar1.add(jMenu1);
    jMenuBar1.add(jMenu2);
    jMenu1.add(jMenuItem2);
    jMenu1.add(jMenuItem3);
    jMenu1.add(jMenuItem4);
    jMenu1.add(jMenuItem5);
    jMenu2.add(jMenuItem6);
    jMenu2.add(jMenuItem7);
    jMenu2.add(jMenuItem8);
    jMenu2.add(jMenuItem9);
    jMenu1.setEnabled(false);
	mainf.setJMenuBar(jMenuBar1);
	this.add(mainp, BorderLayout.CENTER);
    makeInit();
	addListener();
  }
  public void makeInit(){
    mainp.removeAll();
    mainp.setLayout(new BorderLayout());
    mainf.setSize(new Dimension(GrimUtil.WIDTH*GrimUtil.TILES,
        GrimUtil.HEIGHT*(12/GrimUtil.TILES)+GrimUtil.YSPACE));
	mainf.validate();
    String imageNums="image/s12.gif";
    ImageIcon icon = new ImageIcon(imageNums);
    JLabel ll=new JLabel("�׸� ���߱� �����Դϴ�.");
    ll.setIcon(icon);  //�󺧿� ������
    mainp.add(ll);     //
    mainp.updateUI();  //�ֽ� ������� ������Ʈ
  }
  public void make(int stempnumber){
     this.stempnumber=stempnumber;
     mainp.removeAll();
     mainp.setLayout(new GridLayout(stempnumber/GrimUtil.TILES,GrimUtil.TILES));
	 LottoSameTwo gs=new LottoSameTwo(stempnumber);
	 gs.make();
     int [] sames=gs.getBall();
     grim =new GrimButton[sames.length];
     for(int i=0;i<sames.length;i++){
       grim[i]=new GrimButton(sames[i]);   //��ư����
       grim[i].addMouseListener(this);     //������
       mainp.add(grim[i]);
    }
	initImage();
    mainp.updateUI();  //�ֽ� ������� ������Ʈ
    mainf.pack();
  }
   public void addListener(){
	jMenuFileExit.addActionListener(this);
	jMenuHelpAbout.addActionListener(this);
	jMenuItem1.addActionListener(this);
	jMenuItem2.addActionListener(this);
	jMenuItem3.addActionListener(this);
	jMenuItem4.addActionListener(this);
	jMenuItem5.addActionListener(this);
	jMenuItem6.addActionListener(this);
	jMenuItem7.addActionListener(this);
	jMenuItem8.addActionListener(this);
	jMenuItem9.addActionListener(this);
  }
  private void initImage(){
    count=0;
    this.tempGrimButton=null;
    this.iteNum=0;
  }
  public void actionPerformed(ActionEvent e) {
	  if(e.getSource()==jMenuFileExit){
			mainf.dispose();
			System.exit(0);
	  }else if(e.getSource()==jMenuHelpAbout){
			AboutDialog dialog=new AboutDialog(mainf,"�׸����߱� ����",true);
			dialog.setVisible(true);//dialog.show();
	  }else if(e.getSource()==jMenuItem1){
			jMenuItem1.setEnabled(false);
			jMenu1.setEnabled(true);
	  }else if(e.getSource()==jMenuItem2){
			int a=GrimUtil.STEP1*GrimUtil.TILES;
			System.out.println(a+"---------------------------");
			this.make(a);
	  }else if(e.getSource()==jMenuItem3){
			int a=GrimUtil.STEP2*GrimUtil.TILES;
			System.out.println(a+"---------------------------");
			this.make(a);
	  }else if(e.getSource()==jMenuItem4){
			int a=GrimUtil.STEP3*GrimUtil.TILES;
			System.out.println(a+"---------------------------");
			this.make(a);
	  }else if(e.getSource()==jMenuItem5){
			int a=GrimUtil.STEP4*GrimUtil.TILES;
			System.out.println(a+"---------------------------");
			this.make(a);
	  }else if(e.getSource()==jMenuItem6){
			this.speed=GrimUtil.SPEED1;
	  }else if(e.getSource()==jMenuItem7){
			this.speed=GrimUtil.SPEED2;
	  }else if(e.getSource()==jMenuItem8){
			this.speed=GrimUtil.SPEED3;
	  }else if(e.getSource()==jMenuItem9){
			this.speed=GrimUtil.SPEED4;
	  }
  }
  public void mouseClicked(MouseEvent mouseEvent) {}
  public void mouseEntered(MouseEvent mouseEvent) {}
  public void mouseExited(MouseEvent mouseEvent) {}
  public void mousePressed(MouseEvent e) {
    int aa=grim.length;
    for (int i = 0; i < aa; i++) {
      if (e.getSource() == grim[i]) {//���� ��ư�� ���� ��ư
        if(count==0 && grim[i].getClickNum()==0
           && grim[i].backOrFront()==GrimUtil.BACK){
          grim[i].shake();     //�ո�����
          grim[i].setFront();  //�ո����� GrimUtil.FRONT
          this.tempGrimButton=grim[i];  //��� ����
          grim[i].setClickNum();
          count++;
        }//if
        else if(count==1 && grim[i].getClickNum()==0
                && grim[i].backOrFront()==GrimUtil.BACK){
          grim[i].shake();     //�ո�����
          grim[i].setFront();  //�ո����� GrimUtil.FRONT
          grim[i].setClickNum();
          count++;
        }//if
      }//if
    }//for
  }
  public void mouseReleased(MouseEvent e) {
    int aa=grim.length;
    for (int i = 0; i < aa; i++) {
      if (e.getSource() == grim[i]) {
        if(count==2 && grim[i].getClickNum()==1
           && grim[i].backOrFront()==GrimUtil.Front){
            //�� ��ư�� �ո� ��ȣ�� ���ٸ� ��¤�� ���ƾ� �Ѵ�.
            if(this.tempGrimButton.getImageNnum()==grim[i].getImageNnum()){
              iteNum++;            //���� ���� ���� n/2
              if(iteNum==(stempnumber/2)){
                JOptionPane.showMessageDialog(null,"You Win!!!!");
                return;
              }
            }//if
            else{
              try {
                Thread.sleep(speed);   //speed �ʸ� ��ٸ���.
              }
              catch (InterruptedException ex) {
              }
              grim[i].init();
              grim[i].setBack();
              grim[i].setClickNumZero();
              tempGrimButton.setClickNumZero();
              tempGrimButton.setBack();
              tempGrimButton.init();
            }//if
         count=0;  //0�̸� ù��° ��ư, 1�̸� �ι�° ��ư 1�̸� �̹� ����
        }//if
        else if(count==2 && grim[i].getClickNum()==2
                && grim[i].backOrFront()==GrimUtil.Front){
          grim[i].init();
          grim[i].setBack();
          grim[i].setClickNumZero();
          count=0;  //0�̸� ù��° ��ư, 1�̸� �ι�° ��ư 1�̸� �̹� ����
        }
      }//if
    }//for
  }//mouseReleased
}
