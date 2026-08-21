class ConstraintDrivenDesign {

    public static void main(String[] args) {

        int budget = 50000;
        int availableTime = 30;
        int requiredSkills = 3;

        int projectCost = 40000;
        int projectTime = 25;
        int candidateSkills = 4;

        if (projectCost <= budget &&
            projectTime <= availableTime &&
            candidateSkills >= requiredSkills) {

            System.out.println("Solution satisfies all constraints.");
            System.out.println("Project can be implemented.");
        } else {
            System.out.println("Solution does not satisfy the constraints.");
        }
    }
}