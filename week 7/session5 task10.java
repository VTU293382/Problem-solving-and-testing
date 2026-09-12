class ThroneInheritance
class Person {
        String name;
        List<Person> children;

        Person(String name) {
            this.name = name;
            this.children = new ArrayList<>();
        }
    }

    Person king;
    HashMap<String, Person> people;
    HashSet<String> dead;

    public ThroneInheritance(String kingName) {
        king = new Person(kingName);
        people = new HashMap<>();
        dead = new HashSet<>();

        people.put(kingName, king);
    }

    public void birth(String parentName, String childName) {
        Person parent = people.get(parentName);

        Person child = new Person(childName);

        parent.children.add(child);
        people.put(childName, child);
    }

    public void death(String name) {
        dead.add(name);
    }

    public List<String> getInheritanceOrder() {
        List<String> order = new ArrayList<>();

        dfs(king, order);

        return order;
    }

    private void dfs(Person person, List<String> order) {

        if (!dead.contains(person.name)) {
            order.add(person.name);
        }

        for (Person child : person.children) {
            dfs(child, order);
        }
    }
}