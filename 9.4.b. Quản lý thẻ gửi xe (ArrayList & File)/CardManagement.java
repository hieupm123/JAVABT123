import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CardManagement {

	
	public CardManagement()
	{
		super();
	}
	/*
	    Thứ tự nhập như sau:
	    - Số lượng xe
	    - Trong vòng lặp để nhập thông tin mỗi thẻ: nhập số nguyên c = 0 (thẻ học sinh) hoặc 1 (thẻ nhân viên)
	    - Nhập thông tin mỗi thẻ: id, years, day, price, fee (với thẻ sinh viên), và card (với thẻ học sinh)
	*/
	public ArrayList<Card> readData (String fileName)
	{
        ArrayList<Card> A = new ArrayList<>();
        File f = new File(fileName);
		try{
            Scanner sc = new Scanner(f);
            int N = Integer.parseInt(sc.nextLine());
            // System.out.println(N);
            for(int i = 0; i < N; ++i){
                int C = Integer.parseInt(sc.nextLine());
                String id = sc.nextLine();
                int year = Integer.parseInt(sc.nextLine());
                double day = Double.parseDouble(sc.nextLine());
                double price = Double.parseDouble(sc.nextLine());
                if(C == 0){
                    double fee = Double.parseDouble(sc.nextLine());
                    StudentCard st = new StudentCard(id, year, day, price, fee);
                    A.add(st);
                }else{	 	  	 	      	      	     	 	        	 	
                    double tax = Double.parseDouble(sc.nextLine());
                    StaffCard st = new StaffCard(id, year, day, price, tax);
                    A.add(st);
                }
            }
        }catch(Exception err){

        }
		return A;
		
	}
	
	public void printArrayList(ArrayList<Card> cards) {
		for (int i =0;i<cards.size();i++)
			System.out.println(cards.get(i).toString());
	}
	// Hoan thien phuong thuc findCards de tim nhung  xe co nam san xuat la year
	
	public ArrayList<Card> findCards (ArrayList<Card> cards, int year){
		//Begin editable part
        ArrayList<Card> ans = new ArrayList<>();
        for(int i = 0; i < cards.size(); ++i){
            if(cards.get(i).year == year){
                ans.add(cards.get(i));
            }
        }
		return ans;
		//End editable part
	}
	
	// Hoan thien phuong thuc getMaxAmount de tim cac xe thuoc the loai typeOfCard
	public ArrayList<Card> getMaxAmount (ArrayList<Card> cards, String typeOfCard){
        ArrayList<Card> ans = new ArrayList<>();
		//Begin editable part
        double Mx = -10000000;
        for(int i = 0; i < cards.size(); ++i){	 	  	 	      	      	     	 	        	 	
            if(cards.get(i).className().equals(typeOfCard)){
                Mx = Math.max(Mx,cards.get(i).getAmount());   
            }
        }
        for(int i = 0; i < cards.size(); ++i){
            if(cards.get(i).className().equals(typeOfCard) && cards.get(i).getAmount() == Mx){
                ans.add(cards.get(i));
            }
        }
		return ans;
		//End editable part
	}
	
	
	// Hoan thien phuong thuc sortByAmount de sap xep cac xe theo thu tu giam dan
	public void sortByAmount (ArrayList<Card> cards) {
        for(int i = 0; i < cards.size(); ++i){
            for(int j = i + 1; j < cards.size(); ++j){
                if(cards.get(i).getAmount() < cards.get(j).getAmount()){
                    Card tmp = cards.get(i);
                    cards.set(i, cards.get(j));
                    cards.set(j, tmp);
                }
            }
        }
		//Begin editable part
		//End editable part
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		CardManagement cardMng = new CardManagement();
		ArrayList<Card> cards = cardMng.readData("data.txt");
        // cardMng.printArrayList(cards);
	}

}	 	  	 	      	      	     	 	        	 	
