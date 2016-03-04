package kiea.priv.zzz.book.JavaDesignPattern.pattern.P19_State.t01;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SafeFrame extends Frame implements ActionListener, Context
{
	private static final long serialVersionUID = 1L;
	
	private TextField textClock = new TextField(60);
	private TextArea textScreen = new TextArea(10, 60);
	private Button buttonUse = new Button("�ݰ��� ���");
	private Button buttonAlarm = new Button("���");
	private Button buttonPhone = new Button("�Ϲ� ��ȭ");
	private Button buttonExit = new Button("����");
	
	private State state = DayState.getInstance();
	
	@SuppressWarnings("deprecation")
	public SafeFrame(String title)
	{
		super(title);
		setBackground(Color.LIGHT_GRAY);
		setLayout(new BorderLayout());
		
		add(textClock, BorderLayout.NORTH);
		textClock.setEnabled(false);
		
		add(textScreen, BorderLayout.CENTER);
		textScreen.setEnabled(false);
		
		Panel panel = new Panel();
		panel.add(buttonUse);
		panel.add(buttonAlarm);
		panel.add(buttonPhone);
		panel.add(buttonExit);
		
		add(panel, BorderLayout.SOUTH);
		
		pack();
		show();
		
		buttonUse.addActionListener(this);
		buttonAlarm.addActionListener(this);
		buttonPhone.addActionListener(this);
		buttonExit.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		System.out.println(e);
		
		if (e.getSource() == buttonUse) {
			state.doUse(this);
		} else if (e.getSource() == buttonAlarm) {
			state.doAlarm(this);
		} else if (e.getSource() == buttonPhone) {
			state.doPhone(this);
		} else if (e.getSource() == buttonExit) {
			System.exit(0);
		} else {
			System.out.println("?");
		}
	}
	
	public void setClock(int hour)
	{
		String clockString = "���� �ð��� ";
		if (hour < 10)
			clockString += "0" + hour + ":00";
		else
			clockString += hour + ":00";
		
		System.out.println(clockString);
		textClock.setText(clockString);
		state.doClock(this, hour);
	}
	
	public void changeState(State state)
	{
		System.out.println(this.state + "���� " + state + "�� ���°� ��ȭ�߽��ϴ�.");
		this.state = state;
	}
	
	public void callSecurityCenter(String msg)
	{
		textScreen.append("call ! " + msg + "\n");
	}
	
	public void recordLog(String msg)
	{
		textScreen.append("record ... " + msg + "\n");
	}
}
