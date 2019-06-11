package sampletest;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class solution {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		
		
		
		//Scanner s = new Scanner(System.in);
		int t = scanner.nextInt();
        for(int i =0; i< t; i++){
            
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            int result = n;
            int[][] arr = new int[m][n];
            for (int j = 2; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    if(k % n == 0){
                        result += 1;
                    }
                }
            }
            System.out.println(result);
        }
	}
 
		/*Stack<Integer> s = new Stack<>();
		
		int t = scanner.nextInt(); // no of days
		System.out.println(t);
		for (int j =0; j < t; j++){
				String str = scanner.next();
				if(str.equals("pop")){
					s.pop();
					if(!s.isEmpty()){
						System.out.println(s.peek());
					} else {
						System.out.println("EMPTY");
					}
				} else if(str.equals("push")){
					int n = scanner.nextInt();
					s.push(n);
					System.out.println(s.peek());
				} else if (str.equals("inc")) {
					int x = scanner.nextInt();
					int d = scanner.nextInt();
					Stack<Integer> temp = new Stack<>();
					int size = s.size();
					int counter = 0;
					for(int i =1; i<=size; i++){
						if(counter < size - x){
						temp.push(s.peek());
						s.pop();
						
						} else {
							temp.push(s.peek() + d);
							s.pop();
						}
						counter++;
					}
					for(int i = 1; i<=size; i++){
						s.push(temp.peek());
						temp.pop();
					}
					System.out.println(s.peek());
				}
		}*/
	}

				/*String startTime = scanner.next();
				String endTime = scanner.next();
				//String[] strSplit = str.split(" ");
				s.name = str;
				s.startDate = convert(startTime);
				s.endDate = convert(endTime);
				//System.out.println();
				subi.add(s);
			}
			//System.out.println(subi.size());
			Collections.sort(subi);
			list.add(subi);
		}
		scanner.close();
		System.out.println(list.size());
		for(int i =0; i<list.size(); i++){
			System.out.println(list.get(i));
		}
		
		for(List<SubjectDetails> l : list){
			SubjectDetails s0 = list.get(0).get(0);
			int count = 1;
			//Collections.sort(list);
			int i =1;
			while(i<l.size()) {
				if(l.get(i).getStartDate().compareTo(s0.getEndDate()) >= 0){
					count++;
					s0 = l.get(i);
				}
				i++;
			}
			System.out.println(count);
		}
	}
	
	public static Date convert(String time){
		DateFormat sdf = new SimpleDateFormat("hh:mm");
		Date date = new Date();
		try {
			date = sdf.parse(time);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}

}

class SubjectDetails implements Comparable<SubjectDetails> {
	String name;
	Date startDate;
	Date endDate;
	
	public SubjectDetails() {
		// TODO Auto-generated constructor stub
	}
	
	public SubjectDetails(String name, Date startDate, Date endDate) {
		super();
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	 (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 
	@Override
	  public int compareTo(SubjectDetails s) {
	    if (getStartDate() == null || s.getStartDate() == null)
	      return 0;
	    return getStartDate().compareTo(s.getStartDate());
	  }*/
		
