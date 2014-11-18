package ui;

import javax.swing.JFrame;
public class view extends JFrame {

    public static void main(String[] args) {
    	 view v = new view();
    }
    public view() {
        init();
    }

    private void init() {
     
    	User_Frame my=new User_Frame();

    	my.setVisible(true);
    	my.setResizable(false);
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
} 

/*class newThread implements Runnable{
	 public int i=0;
	 view v = new view();
	@Override
	public void run() {
		while(i!=100){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("this is "+i);
			i++;
		}
		
	}	
}
*/