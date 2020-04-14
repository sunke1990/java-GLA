package ALG;

public class NodeDemo1 {
    public static void main(String[] args) {
        HeroNode heroNode1=new HeroNode(1,"JORDAN","FLYING");
        HeroNode heroNode2=new HeroNode(2,"ONEAL","SHARK");
        HeroNode heroNode3=new HeroNode(3,"YAO","BIGMAN");
        HeroNode heroNode4=new HeroNode(4,"WADE","FLASH");
        SingleLinked singleLinked=new SingleLinked();
        singleLinked.addByOrder(heroNode1);
        singleLinked.addByOrder(heroNode2);
        singleLinked.addByOrder(heroNode3);
        singleLinked.addByOrder(heroNode4);
        singleLinked.list();
       /* HeroNode heroNode5=new HeroNode(2,"JAMES","KING");
        singleLinked.update(heroNode5);
        singleLinked.list();*/
        System.out.println(">>>>>>>>>>>>>");
        singleLinked.delete(heroNode4);
        singleLinked.list();
        Exercise exercise=new Exercise();
        var count = singleLinked.count();
        System.out.println(count);
       // System.out.println(singleLinked.noK(3));
        singleLinked.linkedReverse();
        singleLinked.list();

    }
}

class Exercise{
    private HeroNode head=new HeroNode(0,"","");
    public void doubleLinkedDel(HeroNode heroNode){
        HeroNode temp=head;
        if (temp.next==null)
            System.out.println("empty");
        while (true){
            if(temp==heroNode)
                break;
            temp=temp.next;
        }
        temp.pre.next=temp.next;
        temp.next.pre=temp.pre;
    }
    public void doubleLinkedAdd(HeroNode heroNode){
        HeroNode temp=head;
        if (temp.next==null)
            System.out.println("empty");
        while (true){
            if (temp.next==null)
                break;
           temp=temp.next;
        }
        temp.next=heroNode;
        heroNode.pre=temp;
    }
    public int count(HeroNode head){
        int count=0;
        if (head.next==null){return 0;}

        HeroNode temp=head.next;
        while (temp!=null){
            count++;
            temp=temp.next;
        }
        return count;
    }
}

class SingleLinked{
    //链表的反转
    public void linkedReverse(){
        HeroNode reversehead=new HeroNode(0,"","");
        if (head.next==null||head.next.next==null){
           return;
        }
       HeroNode temp= head.next;
       HeroNode next= null;
        while (temp!=null){
            next=temp.next;
            temp.next=reversehead.next;
            reversehead.next=temp;
            temp=next;
        }
        head.next=reversehead.next;
    }
    //查找链表倒数第K个节点
    public HeroNode noK(int k){
       var count = count();
       int flag=count+1-k;
       if (head.next==null){
           System.out.println("链表为空");
       }else if(flag<0){
           System.out.println("k不合法");
       }
       HeroNode temp=head;
       int i=0;
       while (i<flag){
           if(temp.next!=null){
               i++;
               temp=temp.next;
           }
       }
       return temp;

    }

    //链表计数
    public  int count(){
        int count=0;
        if (head.next==null)
            return 0;
        HeroNode temp=head.next;
        while (temp!=null){
            count++;
            temp=temp.next;
        }

        return count;
    }
    private HeroNode head=new HeroNode(0,"","");

    public HeroNode getHead() {
        return head;
    }

    public void setHead(HeroNode head) {
        this.head = head;
    }

    public void delete(HeroNode heroNode){
        HeroNode temp=head;
        if (temp.next==null)
            System.out.println("链表为空");
        while (true){
            if (heroNode.in==temp.next.in){
                break;
            }else {
                temp=temp.next;
            }
        }
        HeroNode flag1=temp.next;
        HeroNode flag2=flag1.next;
        temp.next=flag2;
        while(flag2!=null){
            flag2=flag2.next;
        }
        /*while (true){
            if (flag2==null)
                break;
            else
                flag2=flag2.next;
        }*/


    }
    public void update(HeroNode heroNode){
        HeroNode temp=head;
        if (temp.next==null){
            System.out.println("链表为空");
        }
        while (true){
            if (heroNode.in==temp.in){
                break;
            }else{
                temp=temp.next;
            }
        }
        temp.name=heroNode.name;
        temp.waihao=temp.waihao;
    }
    public void addByOrder(HeroNode heroNode){
        HeroNode temp=head;
        boolean flag=false;
        while (true){
            if(temp.next==null){
                break;
            }
            if(temp.next.in>heroNode.in){
                break;
            }else if(temp.next.in==heroNode.in){
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if(flag){
            System.out.println("英雄已存在，不能添加");
        }else{
            heroNode.next=temp.next;
            temp.next=heroNode;
        }

    }
    public void addSel(HeroNode heroNode, HeroNode target){
        HeroNode temp=head;
           if (temp.next==null)
               System.out.println("链表为空");
        while (temp.next!=target){
            temp=temp.next;
        }
        target=temp.next;
        temp.next=heroNode;
        heroNode.next=target;

    }
    public void add( HeroNode heroNode){
        HeroNode temp=head;
        while(true){
            if(temp.getNext()==null)
                break;
            temp=temp.getNext();
        }
       temp.next=heroNode;

    }
    public void list(){

       if (head.next==null){
           System.out.println("链表为空");
       }
        HeroNode temp=head.next;
       while (true){
           if(temp==null){
               break;
           }
           System.out.println(temp);
           temp=temp.next;

           }
       }

}

class HeroNode{
    public int in;
    public String name;
    public String waihao;
    HeroNode next;
    HeroNode pre;

    public HeroNode(int in, String name, String waihao) {
        this.in = in;
        this.name = name;
        this.waihao = waihao;
    }

    public int getIn() {
        return in;
    }

    public void setIn(int in) {
        this.in = in;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWaihao() {
        return waihao;
    }

    public void setWaihao(String waihao) {
        this.waihao = waihao;
    }

    public HeroNode getNext() {
        return next;
    }

    public void setNext(HeroNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "in=" + in +
                ", name='" + name + '\'' +
                ", waihao='" + waihao + '\'' +
                '}';
    }
}
