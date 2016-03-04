package com.jungbo.three;
import com.jungbo.one.MyMotherFriendSecret;
import com.jungbo.one.MyMotherSecret;
import com.jungbo.one.MySistersSecret;
import com.jungbo.two.MyTopSecret;

public class SecretMain {

	public static void main(String[] args) {
		MyMotherSecret mother=new MyMotherSecret();
		MySistersSecret sister=new MySistersSecret();
		MyMotherFriendSecret mofriend=new MyMotherFriendSecret();
		MyTopSecret my=new MyTopSecret();
		//private,(default),protected�� �Ⱥ���
		System.out.println(mother.getSlushMoney());//public
		System.out.println(mother);//public
		System.out.println(sister.getSlushMoney());//public
		System.out.println(sister);//public
		mofriend.seeMyMother(mother);//���ܸ��� �ƴ� ���� ���
		System.out.println(mofriend);//public
		System.out.println(mofriend.getAddress());//public
		System.out.println(my);//public
		System.out.println(my.getSlushMoney());//public
	}
}
