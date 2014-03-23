package sg.edu.nus.iss.club;

import java.util.*;

public class Club {

	private int numMembers;
	private ArrayList<Member> members;
	private HashMap<String,Facility> facilities;
	
	public Club(){
		numMembers = 0;
		members = new ArrayList<Member>();
		facilities = new HashMap<String,Facility>();
	}
	
// FOR MEMBERS
	public ArrayList<Member> getMembers(){
		@SuppressWarnings("unchecked")
		ArrayList<Member> clone = (ArrayList<Member>)members.clone();
		return clone;
	}
// FOR MEMBERS	
	public Member getMember(int idx){
		 if ((idx < 0) || (idx > numMembers))
			 return null;
		 return members.get(idx-1);
	}
// FOR MEMBERS	
	public void showMembers(){
		//System.out.println("Current Members : "+ getMembers().length);
 		for (Member member:getMembers())
 			if(member != null)
 				System.out.println("* "+member);
	}
// FOR MEMBERS
	public void removeMember(int id){
		if ((id == 0 ) || (id > numMembers))
			return;
		if (members.get(id-1) != null)
			System.out.println("Removing Member with id "+id);
				members.remove(id-1);
		}
// FOR MEMBERS
	public Member addMember(String fname, String sname, String surname){
		numMembers++;
		Member m = new Member(fname,sname,surname,numMembers);
		members.add(m);
		//System.out.println("Last Index of ArrayList= "+members.lastIndexOf(m)+", No of Members = "+numMembers);
		return m;
	}
	
// FOR FACILITY
	public Facility getFacility(String name){
		return facilities.get(name);
	}
	
// FOR FACILITY
	public List<Facility> getFacilities(){
		return (new ArrayList<Facility>(facilities.values()));
	}
// FOR FACILITY
	public Facility addFacility(String name,String desc){
		if (name == null)
			return null;
		Facility f = new Facility(name,desc);
		facilities.put(name, f);
		return f;
	}
		
// FOR FACILITY
	public void removeFacility(String name){
		facilities.remove(name);
	}
		
// FOR FACILITY
	public void showFacilities(){
		for(Facility f : getFacilities()){
			System.out.println("* "+ f);
		}
	}
	
	public void show(){
		showMembers();
		showFacilities();
	}
}
