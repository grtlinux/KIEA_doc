import java.util.*;
public class  CardHands{	
	private int [] points;

	public CardHands() {	
		make();
	}//
	private void init(){
		vCard=new Vector(5,5);
		vCard.clear();
	}
	public void fulling(){
		int count=0;
		while(true){
			Card cd=new Card();// ������ ī�带 �����.
			if(!vCard.contains(cd)){// �������� ���ٸ�
				vCard.addElement(cd);//add
				count++;
			}
			if(count==numOfCards){//40
				break;
			}
		}
	}
	public Vector getAllCards(){
		return vCard;
	}
	public void shuffles(){
		Collections.shuffle(vCard); 
	}
	private void make(){
		init();
		fulling();
	}
}
