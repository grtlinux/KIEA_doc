public class  SameImageMain{
	public static void main(String[] args) {
		StartingJFrame frame=new StartingJFrame();//������
		SameImageJPanel bp=new SameImageJPanel(frame);//�г�
		frame.setMainJpanel(bp);
		frame.validate();
	}
}