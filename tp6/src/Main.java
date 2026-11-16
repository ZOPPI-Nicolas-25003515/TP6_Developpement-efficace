//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

public void bsort() {

}

public void qsort(Queue<K> s, Comparator<K> comp) {
    int n = s.size();
    if (n<2) return;
    //DIVIDE
    K pivot = s.first();
    Queue<K> l,e,g; //new LinkedQueue<>()
    while (!s.isEmpty()) {
        K element = s.dequeue();
        int c=comp.compare(element,pivot);
        if (c<0) {
            L.enqueue(element);
        }
        else if (c==null) {
            l.enqueue(element);
        }
        else {
            g.enqueue(element);
        }
    }
    QSort(l,comp);
    qsort(g,comp);

    while (!l.isEmpty()) {
        s.enqueue(l.dequeue());
        s.enqueue(e.dequeue());
        s.enqueue(g.dequeue());
    }



    /*
    K temp;
    for (int i = 0; i < p; ++i) {
        if (k.compareInf(s.get(i),s.get(p))) {
            temp = k.get(i + 1)
        }
    }

     */
}

void main() {
    ArrayList<Integer> list = new ArrayList<Integer>();
    list.add(9);
    list.add(4);
    list.add(6);
    list.add(9);
    list.add(5);
    list.add(3);
    list.add(1);

    ArrayList<Integer> list2 = new ArrayList<Integer>();
    list2.add(9);
    list2.add(4);
    list2.add(6);



}
