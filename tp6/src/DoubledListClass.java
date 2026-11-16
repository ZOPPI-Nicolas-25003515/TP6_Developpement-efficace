import java.util.Objects;

public class DoubledListClass {
    private DNode header;

    private DoubledListClass() {
        header = null;
    }

    public DoubledListClass(DNode header) {
        this.header = header;
        header.setPred(null);
    }

    public DNode getHeader () {
        return this.header;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof DoubledListClass that)) return false;
        return Objects.equals(header, that.header);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(header);
    }

    public int size () {
        DNode node = this.header;
        if (node == null) {
            return 0;
        }
        int count = 1;
        while (true) {
            if (node.getNext() != null) {
                ++count;
                node = node.getNext();
            }
            else break;
        }
        return count;
    }

    public int size2 () {
        DNode node = this.header;
        if (node == null) {
            return 0;
        }
        int count = 1;
        while (true) {
            if (node.getNext() != this.header) {
                ++count;
                node = node.getNext();
            }
            else break;
        }
        return count;
    }

    public boolean isEmpty() {
        return header == null;
    }


    public void addLast(Integer element) {
        DNode newDNode = new DNode(element);

        if (header == null) {
            header = newDNode;
            return;
        }

        DNode tmpHeader = header;
        while (tmpHeader.getNext() != null) {
            tmpHeader = tmpHeader.getNext();
        }
        tmpHeader.setNext(newDNode);

    }

    public DNode first() {
        if(isEmpty()) {
            return null;
        }else {
            return header;
        }
    }

    public Integer last() {
        if(isEmpty()) {
            return null;
        }

        DNode current = header;
        while(current.getNext() != null) {
            current = current.getNext();
        }
        return current.getElement();
    }

    public void addFirst(Integer element) {
        DNode tmpHeader = new DNode(element);
        tmpHeader.setNext(header);
        this.header = tmpHeader;
    }

    @Override
    public String toString() {
        if (header == null) return "";
        StringBuilder sb = new StringBuilder(header.toString());
        DNode current = header;
        while (current.getNext() != null) {
            current = current.getNext();
            sb.append("," + current.toString());
        }

        return sb.toString();
    }

    public DNode removeFirst() {
        if (isEmpty()) {
            return null;
        }
        else {
            header = header.getNext();
            return header;
        }
    }

    public DNode findBeforeLast() {
        if (this.size() <= 2) return header;
        DNode node = this.header;
        while (node.getNext() != null) {
            node = node.getNext();
        }
        return node.getPred();
    }

    private static class DNode {

        private Integer element;
        private DNode pred;
        private DNode next;

        public DNode(Integer element) {
            this.element = element;
        }

        public DNode (Integer e, DNode p, DNode n) {
            element = e;
            pred = p;
            next = n;
        }

        public String toString() {
            return element.toString();
        }

        public Integer getElement () {
            return element;
        }

        public DNode getNext() {
            return next;
        }

        public void setNext (DNode newNext) {
            newNext.pred = this;
            next = newNext;

        }

        public DNode getPred() {
            return pred;
        }

        public void setPred(DNode newPred) {
            newPred.next = this;
            pred = newPred;
        }

        public void setElement(Integer newElem) {
            element = newElem;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof DNode that)) return false;
            return element.equals(that.element)
                    && Objects.equals(next, that.next);
        }
    }

    public static void main(String[] args) {
        DoubledListClass maListe = new DoubledListClass();
        maListe.addLast(5);
        maListe.addLast(6);
        maListe.addLast(7);


        DoubledListClass maListe2 = new DoubledListClass();
        maListe2.addLast(5);
        maListe2.addLast(6);
        maListe2.addLast(7);
        System.out.println("vide : " + maListe2.isEmpty() + "\n");
        System.out.println("test2 (5):" + maListe.getHeader() + "\n");
        System.out.println("test2 (6):" + maListe.getHeader().getNext() + "\n");
        System.out.println("test2 (7):" + maListe.getHeader().getNext().getNext() + "\n");
        System.out.println("to String : " + maListe + "\n");
        maListe.addFirst(9);
        System.out.println("On ajoute un 9 au debut : " + maListe.getHeader() + ", Le premier chiffre est bien " + maListe.first() + "\n");
        System.out.println("to String : " + maListe.toString() + "\n");
        System.out.println(maListe2.isEmpty() + "\n");
        maListe2.addFirst(485);
        System.out.println(maListe2.toString() + "\n");
        maListe2.addFirst(584);
        System.out.println(maListe2 + "\n");
        System.out.println("Taille de la première liste : " + maListe.size() + "\nTaille de la seconde liste : " + maListe2.size() + "\n");
        System.out.println(maListe.findBeforeLast());

        DoubledListClass listeCirculaire = new DoubledListClass();
        listeCirculaire.addLast(1);
        listeCirculaire.addLast(2);
        listeCirculaire.addLast(3);
        listeCirculaire.addLast(4);
        listeCirculaire.addLast(5);

        listeCirculaire.findBeforeLast().getNext().setNext(listeCirculaire.getHeader());

        System.out.println(listeCirculaire.size2());

        DoubledListClass maListe3 = new DoubledListClass();
        maListe3.addLast(1);
        maListe3.addLast(2);
        maListe3.addLast(3);
        maListe3.addLast(4);
        maListe3.addLast(5);
        maListe3.addLast(6);

        DoubledListClass maListe4 = new DoubledListClass();
        maListe4.addLast(1);
        maListe4.addLast(2);
        maListe4.addLast(3);
        maListe4.addLast(4);
        maListe4.addLast(5);
        maListe4.addLast(6);

        System.out.println("Liste 3 : \n" + maListe3 + "\nListe 4 : \n" + maListe3);

        System.out.println(maListe3.equals(maListe4));
    }
}
