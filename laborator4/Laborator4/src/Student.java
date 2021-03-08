import java.util.*;
public class Student {
    String name;
    List<School> preferences= new List<School>() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator<School> iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public <T> T[] toArray(T[] a) {
            return null;
        }

        @Override
        public boolean add(School school) {
            return false;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends School> c) {
            return false;
        }

        @Override
        public boolean addAll(int index, Collection<? extends School> c) {
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public School get(int index) {
            return null;
        }

        @Override
        public School set(int index, School element) {
            return null;
        }

        @Override
        public void add(int index, School element) {

        }

        @Override
        public School remove(int index) {
            return null;
        }

        @Override
        public int indexOf(Object o) {
            return 0;
        }

        @Override
        public int lastIndexOf(Object o) {
            return 0;
        }

        @Override
        public ListIterator<School> listIterator() {
            return null;
        }

        @Override
        public ListIterator<School> listIterator(int index) {
            return null;
        }

        @Override
        public List<School> subList(int fromIndex, int toIndex) {
            return null;
        }
    };

    public Student(String name) {
        this.name = name;
    }

    public Student(String name, List<School> preferences) {
        this.name = name;
        this.preferences = preferences;
    }

    public void addPreferences(List<School> preferences){
        for(int i=0; i<this.preferences.size(); i++)
            this.preferences.add(preferences.get(i));
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' + '}';
    }
}
