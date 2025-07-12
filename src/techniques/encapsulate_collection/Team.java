package techniques.encapsulate_collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Team {
    private String name;
    private List<String> members;

    public Team(String name) {
        this.name = name;
        this.members = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<String> getMembers() {
        return Collections.unmodifiableList(members);
    }

    public void setMembers(List<String> members){
        this.members = new ArrayList<>(members);
    }

    public void addMember(String member){
        this.members.add(member);
    }
    public void removeMember(String member){
        this.members.remove(member);
    }


    public static void main(String[] args) {
        Team softwareTeam = new Team("Software Development");
        //addMember를 사용하도록 수정
        softwareTeam.addMember("Alice");
        softwareTeam.addMember("Bob");

        System.out.println("Team : " + softwareTeam.getName());
        System.out.println("Members : " + softwareTeam.getMembers());

        List<String> teamMembersView = softwareTeam.getMembers();
        try{
            teamMembersView.add("Charlie");
        } catch (UnsupportedOperationException e){
            System.out.println("Error");
        }

        //외부에서 컬렉션을 통쨰로 교체함
        List<String> newMembers = new ArrayList<>();
        newMembers.add("Charlie");
        softwareTeam.setMembers(newMembers);
        System.out.println("New Members :" + softwareTeam.getMembers());

        newMembers.add("David"); //복제본을 전달했기 때문에 newMembers의 값이 변경되어도 Team의 members 에는 영향이 없음

        softwareTeam.removeMember("Charlie");
        System.out.println("Members after removal :" + softwareTeam.getMembers());
    }
}
