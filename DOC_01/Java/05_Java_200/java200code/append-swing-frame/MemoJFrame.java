public class MemoJFrame extends AbstractJFrame {
        private static final long serialVersionUID=122342166345L;//JAVA5
        private MemoJPanel  mp=null;
        public MemoJFrame(String title) {
          super(title);
        }
        public void addListeners() {//AwtAbstractJFrame ����ȣ��
          //-------�ʹޱ�-------//
        }
        public void inits() {//AwtAbstractJFrame ���� ȣ��
          mp=new MemoJPanel();
          setMainJpanel(mp);
          //----�ʼ�----//
          this.setSize(400,300);
        }
}
