import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
public class MemoJPanel extends BaseJPanel {
        private static final long serialVersionUID=122342166345L;//JAVA5
        private JPanel centerP =new JPanel();
        private JPanel eastP   =new JPanel();
        private JPanel cnorthP  =new JPanel();
        private JPanel csouthP  =new JPanel();
        private JPanel ccenterP  =new JPanel();

        private JButton button1=new JButton("Add Text");
        private JButton button2=new JButton("  Clear ");
        private JButton buttonbf=new JButton("BoldFont");
        private JButton buttonLg=new JButton(" Larger ");
        private JButton buttonSm=new JButton(" Smaller");

        private JLabel memolb=new JLabel("MEMO",JLabel.CENTER );
        private JLabel eastLb1=new JLabel("��ġ�� Ȯ������.",JLabel.CENTER );
        private JTextArea memoArea=new JTextArea(40,7);//40�� 7��
        private JTextField inputFd=new JTextField(40);//40��
        public MemoJPanel() {
                super();
                System.out.println("MemoJPanel -----������");
                starts();//�θ��� start addListeners, inits() ȣ��
        }
        public void addListeners() {//�ݵ�� ����
                //-------�ʹޱ�-------//
        }
        public void inits() {//�ݵ�� ����
                System.out.println("MemoJPanel ----inits");
                this.setLayout(new BorderLayout());
                this.add(centerP, "Center");
                this.add(eastP, "East");
                this.add(cnorthP,"North");
                centerP.setLayout(new BorderLayout());
                centerP.add(ccenterP,"Center");
                centerP.add(csouthP,"South");
                //Dialog, DialogInput, Monospaced, Serif, SansSerif
                //PLAIN, BOLD ,ITALIC ,BOLD|ITALIC
                memolb.setFont(new Font("SansSerif", Font.BOLD,25));
                cnorthP.setLayout(new BorderLayout());
                cnorthP.add(memolb,"Center");
                ccenterP.setLayout(new BorderLayout());
                JScrollPane spl =new JScrollPane(memoArea);
                ccenterP.add(spl,"Center");
                memoArea.setWrapStyleWord(true);
                memoArea.setLineWrap(true);//������ ������ �����ٷ� �ڵ��̵�
                csouthP.setLayout(new BorderLayout());
                csouthP.add(inputFd);
                eastP.setPreferredSize(new Dimension(100,300));
                eastP.add(button1);
                eastP.add(button2);
                eastP.add(buttonbf);
                eastP.add(buttonLg);
                eastP.add(buttonSm);
                eastP.add(eastLb1);
        }
}
