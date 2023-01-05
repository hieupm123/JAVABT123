import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
public class CarManagement {
	
	// Hàm dựng 
	public CarManagement(){
		super();
	}
	
	// Phương thức readData() cho phép đọc dữ liệu từ tệp văn bản
	/*
	    Thứ tự nhập như sau:
	    - Nhập số lượng xe
	    - Trong vòng lặp với mỗi loại xe:
	       - Nhập 1 số nguyên c, c = 0 là ServiceCar, c = 1 là SportCar
	       - Nhập thông tin của các xe: id, name, manufacturer, hours, price, fee (Đối với ServiceCar, tax với SportCar)
	*/
	
	public ArrayList<Car> readData(String fileName) {
        File f = new File(fileName);
        ArrayList<Car> A = new ArrayList<>();
        try{
            Scanner sc = new Scanner(f);
            int N = Integer.parseInt(sc.nextLine());
            for(int i = 0; i < N; ++i){
                int C = Integer.parseInt(sc.nextLine());
                String id = sc.nextLine();
                String name = sc.nextLine();
                String manufacturer = sc.nextLine();
                double hours = Double.parseDouble(sc.nextLine());
                double price = Double.parseDouble(sc.nextLine());
                if(C == 0){
                    double fee = Double.parseDouble(sc.nextLine());
                    ServiceCar tmp = new ServiceCar(id,name,manufacturer,hours,price,fee);
                    A.add(tmp);
                }else{	 	  	 	      	      	     	 	        	 	
                    double tax = Double.parseDouble(sc.nextLine());
                    SportCar tmp = new SportCar(id,name,manufacturer,hours,price,tax);
                    A.add(tmp);
                }
                // System.out.println(C);
            }
            sc.close();
        }
        catch(Exception a){

        }
		return A;
			
	}
	
	// Phương thức in danh sách thông tin liên quan các loại xe trong mảng
	public void printCars(ArrayList<Car> cars) {
		for (int i = 0; i < cars.size(); i++) {
			System.out.println(cars.get(i).toString());
		}
	}
	
	// Phương thức xuất ra danh sách những xe có tên nhà sản xuất là "manuName"
	public ArrayList<Car> findCars(ArrayList<Car> cars, String manuName){
        ArrayList<Car> res = new ArrayList<>();
        for(int i = 0; i < cars.size(); ++i){
            if(cars.get(i).getManufacturer().equals(manuName)){
                res.add(cars.get(i));
            }
        }
		return res;
	}
	
	// Phương thức xuất ra danh sách những xe giá thành tiền (amount) cao nhất thuộc loại typeOfCars
	
	public ArrayList<Car> getMaxAmount(ArrayList<Car> cars, String typeOfCars){	 	  	 	      	      	     	 	        	 	
        double ans = -1000000;
        ArrayList<Car> tmp = new ArrayList<>();

		for(int i = 0; i < cars.size(); ++i){
            if(cars.get(i).getClassName().equals(typeOfCars)){
                // System.out.println(cars.get(i).getClassName());
                ans = Math.max(ans,cars.get(i).getAmount());
            }
        }
        for(int i = 0; i < cars.size(); ++i){
            if(ans == cars.get(i).getAmount() && cars.get(i).getClassName().equals(typeOfCars)){
                tmp.add(cars.get(i));
            }
        }
		return tmp;
	}
	
	// Phướng thức sắp xếp giá thành tiền các loại xe theo thứ tự giảm dần
	public void sortByAmount(ArrayList<Car> cars){
		//Begin editable part
		for(int i = 0; i < cars.size(); ++i){
            for(int j = i + 1; j < cars.size(); ++j){
                if(cars.get(i).getAmount() < cars.get(j).getAmount()){
                    Car tmp = cars.get(i);
                    cars.set(i,cars.get(j));
                    cars.set(j, tmp);
                }
            }
        }
	}

// Hàm main 
		public static void main(String[] args) {
			CarManagement carManag = new CarManagement();
			ArrayList<Car> cars = carManag.readData("data.txt");
		//	carManag.printCars(cars);
			
			for (int i = 0; i < cars.size(); i++) {	 	  	 	      	      	     	 	        	 	
                // System.out.print(cars.get(i).getClassName());
				System.out.print(cars.get(i).getAmount() + " ");
			}
			System.out.println();
			ArrayList<Car> carsList = carManag.findCars(cars,"honda");
			carManag.printCars(carsList);
			
			ArrayList<Car> carsList1 = carManag.getMaxAmount(cars, "SportCar");
			carManag.printCars(carsList1);
			
			carManag.sortByAmount(cars);
			carManag.printCars(cars);
			
		}
	}