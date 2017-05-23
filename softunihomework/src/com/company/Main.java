package com.company;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Comparator.comparing;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numberOfBooks = Integer.parseInt(scan.nextLine());
        List<Book>libraryInfo = new ArrayList<>();
        Map<String,Double>authorsIncomes = new HashMap<>();
        for (int i = 0; i < numberOfBooks ; i++) {
            Object[]line =  Arrays.stream(scan.nextLine().split(" ")).toArray();
            String currentTitle = line[0].toString();
            String currentAuthor = line[1].toString();
            String currentPublisher = line[2].toString();
            String currentisbn = line[4].toString();
            Double currentPrice = Double.parseDouble(line[5].toString());
            String releaseDate = line[3].toString();
            Book currentBook = new Book(currentTitle,currentAuthor,currentPublisher,releaseDate,currentisbn,currentPrice);
            libraryInfo.add(currentBook);
            if(!authorsIncomes.containsKey(currentAuthor)){
                authorsIncomes.put(currentAuthor,currentPrice);
            }else{
                double income = authorsIncomes.get(currentAuthor)+currentPrice;
                authorsIncomes.replace(currentAuthor,income);
            }
        }


        for (String name: authorsIncomes.keySet()){

            String key =name.toString();
            Double value = authorsIncomes.get(name);
            System.out.printf("%s -> %.02f",key,value);
            System.out.println();


        }
       // List<Student> sorted = result.stream().sorted(comparing(Student::getName).thenComparing(comparing(Student::getAverageGrades).reversed())).collect(Collectors.toList());


//        for (Student student:sorted) {
//            System.out.printf("%s -> %.2f",student.name,student.averageGrade);
//            System.out.println();
//        }
//        System.out.println();


       // title} {author} {publisher} {release date} {ISBN} {price}
    }

    public static class Book{
        String title ;
        String author;
        String publisher;
        String releaseDate;
        String isbn;
        Double price;

        public Book(String title, String author, String publisher, String releaseDate, String isbn, Double price) {
            this.title = title;
            this.author = author;
            this.publisher = publisher;
            this.releaseDate = releaseDate;
            this.isbn = isbn;
            this.price = price;
        }

    }

    public static class Library{
        String name;
        List<Book>books;
        public Library(String name, List<Book> books) {
            this.name = name;
            this.books = books;
        }

        Double income;


    }
    public static void SortByNameThenByGrades(){
        Scanner scan = new Scanner(System.in);
        ArrayList<Student>studentsInfo=new ArrayList<Student>();
        int numberOfStudents = Integer.parseInt(scan.nextLine());
        for (int i = 0; i< numberOfStudents;i++){
            Object[] currentStudentInfo = Arrays.stream(scan.nextLine().split(" ")).toArray();
            ArrayList<Double>grades = new ArrayList<>();
            String name = currentStudentInfo[0].toString();
            for (int g = 1;g < currentStudentInfo.length;g++ ) {
                grades.add(Double.parseDouble(currentStudentInfo[g].toString()));
            }
            Student currentStudent = new Student(name,grades);
            studentsInfo.add(currentStudent);
        }

        List<Student>result = studentsInfo.stream().filter(x -> x.averageGrade >=5).collect(Collectors.toList());

        List<Student> sorted = result.stream().sorted(comparing(Student::getName)
                .thenComparing(comparing(Student::getAverageGrades).reversed())).collect(Collectors.toList());


        for (Student student:sorted) {
            System.out.printf("%s -> %.2f",student.name,student.averageGrade);
            System.out.println();
        }
        System.out.println();
    }

    public static class Student{
        String name ;
        ArrayList<Double> grades ;
        Double averageGrade;
        public Student(String name, ArrayList<Double> grades){
            this.name = name;
            this.grades = grades;
            double sumOfGrades = 0;
            for (double grade:grades) {
                sumOfGrades+=grade;
            }
            averageGrade = (Double) sumOfGrades/grades.size();
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public double getAverageGrades() {
            return averageGrade;
        }


    }


    public static void IntersectCircles(){
        Scanner scan = new Scanner(System.in);
        double[]firstCircleInfo = Arrays.stream(scan.nextLine().split(" ")).mapToDouble(Double :: parseDouble).toArray();
        double[]secondCircleInfo = Arrays.stream(scan.nextLine().split(" ")).mapToDouble(Double :: parseDouble).toArray();

        double distance = Math.sqrt(Math.pow(firstCircleInfo[0]-secondCircleInfo[0],2)+Math.pow(firstCircleInfo[1]-secondCircleInfo[1],2));
        if (distance<=firstCircleInfo[2]+secondCircleInfo[2]){
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }
    }

    public class Circle{
        Point center;
        double radius;
        public Circle(Point center,double radius){
            this.center = center;
            this.radius = radius;
        }
    }
    public static class Point{
        double x ;
        double y;
        public Point(double x, double y){
            this.x = x;
            this.y = y;
        }
    }

    public static void RandomMessage(){
        String[] phrases = {"Excellent product.", "Such a great product.", "I always use that product.", "Best product of its category.", "Exceptional product.", "I can’t live without this product."};
        String[] events = {"Now I feel good.", "I have succeeded with this product.", "Makes miracles. I am happy of the results!", "I cannot believe but now I feel awesome.", "Try it yourself, I am very satisfied.", "I feel great!"};
        String[] authors = {"Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"};
        String [] cities = {"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"};

        Scanner scan = new Scanner(System.in);
        int numberOfMessages = Integer.parseInt(scan.nextLine());

        for (int i=0;i<numberOfMessages;i++){
            Random index = new Random();
            int phraseIndex = index.nextInt(phrases.length);
            index = new Random();
            int eventIndex =  index.nextInt(events.length);
            index = new Random();
            int authorIndex =  index.nextInt(authors.length);
            index = new Random();
            int townIndex =  index.nextInt(cities.length);
            System.out.printf("%s %s %s – %s.", phrases[phraseIndex],events[eventIndex],authors[authorIndex],cities[townIndex]);
            System.out.println();
        }
    }

    public static void WorkingDays(){
        Scanner sc = new Scanner(System.in);
        String firstLine = sc.nextLine();
        String secondLine = sc.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate firstDate = LocalDate.parse(firstLine, formatter);
        LocalDate secondDate = LocalDate.parse(secondLine, formatter);

        long days = ChronoUnit.DAYS.between(firstDate, secondDate);

        int workingDays = 0;
        for (int i = 0; i <= days; i++) {
            boolean workday = checkIfHoliday(firstDate);

            if (!workday ) {
                workingDays++;
            }
            firstDate = firstDate.plusDays(1);
        }
        System.out.println(workingDays);
    }

    private static boolean checkIfHoliday(LocalDate date) {
            if
                    ((date.getDayOfMonth() == 1 && date.getMonth().getValue() == 1) ||
                    (date.getDayOfMonth() == 3 && date.getMonth().getValue() == 3) ||
                    (date.getDayOfMonth() == 1 && date.getMonth().getValue() == 5) ||
                    (date.getDayOfMonth() == 6 && date.getMonth().getValue() == 5) ||
                    (date.getDayOfMonth() == 24 && date.getMonth().getValue() == 5) ||
                    (date.getDayOfMonth() == 6 && date.getMonth().getValue() == 9) ||
                    (date.getDayOfMonth() == 22 && date.getMonth().getValue() == 9) ||
                    (date.getDayOfMonth() == 1 && date.getMonth().getValue() == 11) ||
                    (date.getDayOfMonth() == 24 && date.getMonth().getValue() == 12) ||
                    (date.getDayOfMonth() == 25 && date.getMonth().getValue() == 12) ||
                    (date.getDayOfMonth() == 26 && date.getMonth().getValue() == 12)
                    ) {
                return true;
            } else if (
                    (date.getDayOfWeek().getValue() == 6) ||
                            (date.getDayOfWeek().getValue() == 7)
                    ) {
                return true;
            } else {
                return false;
            }

        }

    public static void HexadecimalNumber(){
        Scanner scan = new Scanner(System.in);
        String input = scan.next();
        int num = Integer.parseInt(input,16);
        System.out.println(num);
    }
    public static void BooleanVar(){
        Scanner scan = new Scanner(System.in);
        String input = scan.next();
        boolean variable = Boolean.parseBoolean(input);
        if(variable){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }

    public static void ReversedString(){
        Scanner scan = new Scanner(System.in);
        String result = "";
        for (int i=0; i<3;i++) {
            String input = scan.next();
            result=input+result;

        }
        System.out.println(result);
    }

    public static void VowelOrDigit(){
        Scanner scan = new Scanner(System.in);
        String input = scan.next().toLowerCase();

        switch (input){

            case "a":
            case "e":
            case "i":
            case "o":
            case "u":
            case "y":
                System.out.println("vowel");
                break;
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
            case "0":
                System.out.println("digit");
                break;
            default:
                System.out.println("other");
                break;
        }
    }

    public static void InttoHexAndBinary(){
        Scanner scan = new Scanner(System.in);
        Long num = Long.parseLong(scan.next());

        String hex = Long.toHexString(num).toUpperCase();
        String bin = Long.toBinaryString(num);
        System.out.println(hex);
        System.out.println(bin);
    }

    public static void CompareTwoCharArrays(){
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine().toLowerCase();
        String [] firstarr = input.split(" ");
        input = scan.nextLine().toLowerCase();
        String [] secarr = input.split(" ");
        Integer maxlength = Math.min(firstarr.length,secarr.length);

        boolean print = false;
        int bigger = 0;
        for (int i = 0; i < maxlength; i++) {
            if(firstarr[i].compareTo(secarr[i])>0){
                bigger=1;
            }else if(firstarr[i].compareTo(secarr[i])<0){
                bigger=2;
            }
        }
        if(bigger==0){
            if(firstarr.length>secarr.length){
                bigger=1;
            }else if(firstarr.length>secarr.length){
                bigger=2;
            }
        }
        switch (bigger){
            case 0:
            case 1:
                for (String ch:secarr ) {
                    System.out.print(ch);
                }
                System.out.println();
                for (String ch:firstarr ) {
                    System.out.print(ch);
                }
                break;
            case 2:
                for (String ch:firstarr ) {
                    System.out.print(ch);
                }
                System.out.println();
                for (String ch:secarr ) {
                    System.out.print(ch);
                }
                break;
        }
    }

    public static void MaxSequence(){
        Scanner scan = new Scanner(System.in);
        int [] numbers =Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int prevNum=numbers[0];
        boolean isEqual = true;
        int maxLen = 1;
        int currLen = 1;
        int maxIndex =0;
        for (int i = 1; i < numbers.length; i++) {
            int currentNum = numbers[i];
            if (currentNum==prevNum){
                currLen++;
            }else{
                if(currLen>maxLen){
                    maxLen=currLen;
                    maxIndex=i-1;
                }
                currLen=1;
            }
            prevNum=currentNum;
        }
        int bestStart =maxIndex-maxLen+1;
        int bestLen = maxIndex+1;
        if(currLen>1 && currLen>maxLen){
            bestStart = 0;
            bestLen=numbers.length;
        }
        for (int i =bestStart; i <bestLen ; i++) {
            System.out.print(numbers[i]+" ");
        }
        System.out.println();
    }
    public static void MaxIncreasSeq() {
        Scanner scan = new Scanner(System.in);
        int [] numbers =Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int prevNum=numbers[0];
        boolean isEqual = true;
        int maxLen = 1;
        int currLen = 1;
        int maxIndex =0;
        for (int i = 1; i < numbers.length; i++) {
            int currentNum = numbers[i];
            if (currentNum>prevNum){
                currLen++;
            }else{
                if(currLen>maxLen){
                    maxLen=currLen;
                    maxIndex=i-1;
                }
                currLen=1;
            }
            prevNum=currentNum;
        }
        int bestStart =maxIndex-maxLen+1;
        int bestLen = maxIndex+1;
        if(currLen>1 && currLen>maxLen){
            if(maxIndex==0){
                bestLen=currLen;
                bestStart=0;

            }else{
                bestStart = numbers.length-maxIndex-currLen+1;
                bestLen=currLen+bestStart;
            }

        }
        for (int i =bestStart; i <bestLen ; i++) {
            System.out.print(numbers[i]+" ");
        }
        System.out.println();



    }

    public static void MostFreqNum(){
        Scanner scan = new Scanner(System.in);
        int [] numbers =Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Map<Integer,Integer> countNumbers = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length ; i++) {
            int currentNum = numbers[i];
            if (!countNumbers.containsKey(currentNum)){
                countNumbers.put(currentNum,1);
            }else{
                countNumbers.put(currentNum,countNumbers.get(currentNum)+1);
            }
        }
        int maxValue =0;
        for (int value:countNumbers.values()) {
            if (value>maxValue){
                maxValue=value;
            }
        }
        for (int key:countNumbers.keySet()) {
            if (countNumbers.get(key)==maxValue){
                System.out.println(key);
            }
        }

    }

    public static void MostFreqNumArr(){
        Scanner scan = new Scanner(System.in);
        int [] numbers =Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(numbers);
        int maxValue =0;

        int prevNum = numbers[0];
        int mostFreqNum=prevNum;
        int count=1;
        for (int i = 1; i < numbers.length ; i++) {
            int currentNum = numbers[i];
            if (currentNum==prevNum){
                count++;
            }else{
                if (count>maxValue){
                    maxValue=count;
                    mostFreqNum=prevNum;
                }else{
                    count=1;
                }
            }
            prevNum=currentNum;
        }
        if(count>maxValue){
            mostFreqNum=prevNum;
        }

        System.out.println(mostFreqNum);
    }

    public static void IndexOfLetters(){
        Map<Character,Integer> alphabet = new HashMap<Character,Integer>();
        int value = 0;
        for (char key = 'a'; key<='z';key++){
            alphabet.put(key,value);
            value++;
        }
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        for (int i =0;i<input.length();i++) {
            char letter = input.charAt(i);
            System.out.print(letter);
            System.out.println(" -> "+alphabet.get(letter));
        }
    }

    public static void EqualSums(){
        Scanner scan = new Scanner(System.in);
        int [] numbers =Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        boolean isPrint=false;

        if (numbers.length<=1){
            System.out.println("0");
            isPrint=true;
        }else{
            for (int i = 1; i < numbers.length-1 ; i++) {

                int[] leftPart = Arrays.copyOfRange(numbers,0,i);
                int[] rightPart = Arrays.copyOfRange(numbers,i+1,numbers.length);
                int leftSum = IntStream.of(leftPart).sum();
                int rightSum =IntStream.of(rightPart).sum();
                if (leftSum==rightSum){
                    System.out.println(i);
                    isPrint = true;
                }
            }
            if (IntStream.of(Arrays.copyOfRange(numbers,0,numbers.length)).sum()==0){
                System.out.println(numbers.length-1);
                isPrint = true;
            }

        }
        if (!isPrint){
            System.out.println("no");
        }
    }

    public static void ReverseString(){
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        String result = new StringBuilder(input).reverse().toString();
        System.out.println(result);
    }

    public static void FitStr(){
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        if (input.length()>=20){
            String result = input.substring(0,20);
            System.out.println(result);
        }else{
            System.out.print(input);
            for (int i = 0; i < 20-input.length(); i++) {
                System.out.print("*");
            }
         }
    }

    public static void CensorEmail(){
        Scanner scan = new Scanner(System.in);
        String email = scan.nextLine();
        String textToCensor = scan.nextLine();
        String toChange = email.split("@")[0];
        StringBuilder newstring = new StringBuilder();
        for (int i = 0; i < toChange.length(); i++) {
            newstring.append("*");
        }
        newstring.append("@");
        newstring.append(email.split("@")[1]);
        String result = newstring.toString();
        String changedText = textToCensor.replace(email,result);
        System.out.print(changedText);
    }

    public static void URLParser(){
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String protokol = "";
        String server = "";
        String resource = "";

        if(input.indexOf("://")!=-1){
            protokol=input.split("://")[0];
            String rest = input.split("://")[1];
            if (rest.indexOf("/") !=-1){
                server=rest.split("/")[0];
                resource = rest.substring(rest.indexOf("/")+1);
            }else{
                server=rest;
            }

        }else{
            if (input.indexOf("/") !=-1){
                server=input.split("/")[0];
                resource = input.substring(input.indexOf("/")+1);
            }else{
                server=input;
            }
        }

        System.out.println("[protocol]"+ " = \""+ protokol+"\"");
        System.out.println("[server]"+ " = \""+ server+"\"");
        System.out.println("[resource]"+ " = \""+ resource+"\"");


    }

    public static void ChangeToUpper(){
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String toUpper="";

        while (input.indexOf("<upcase>")>=0){
            int startIndex=input.indexOf("<upcase>");
            input=input.replaceFirst("<upcase>","");
            int endIndex =input.indexOf("</upcase>");
            input=input.replaceFirst("</upcase>","");
            toUpper=input.substring(startIndex,endIndex).toUpperCase();
            input=input.replace(input.substring(startIndex,endIndex),toUpper);

        }

        System.out.print(input);
    }

    public static void Phonebook(){
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Map<String,String> phonebook = new HashMap<>();

        while (!input.equals("END")){
            String [] credentials = input.split(" ");
            String command = credentials[0];
            switch (command){
                case "A":
                    phonebook.put(credentials[1],credentials[2]);
                    break;
                case "S":
                    if (phonebook.containsKey(credentials[1])){
                        System.out.println(credentials[1]+" -> "+phonebook.get(credentials[1]));
                    }else{
                        System.out.println("Contact "+credentials[1]+" does not exist.");
                    }
                    break;
            }
            input = scan.nextLine();

        }

    }

    public static void UpgradePhonebook(){
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Map<String, String> phonebook = new TreeMap<>();

        while (!input.equals("END")) {
            String[] credentials = input.split(" ");
            String command = credentials[0];
            switch (command) {
                case "A":
                    phonebook.put(credentials[1], credentials[2]);
                    break;
                case "S":
                    if (phonebook.containsKey(credentials[1])) {
                        System.out.println(credentials[1] + " -> " + phonebook.get(credentials[1]));
                    } else {
                        System.out.println("Contact " + credentials[1] + " does not exist.");
                    }
                    break;
                case "ListAll":
                    for (String key : phonebook.keySet()) {
                        String value = phonebook.get(key);
                        System.out.println(key + " -> " + value);
                    }
            }
            input = scan.nextLine();

        }
    }
}
