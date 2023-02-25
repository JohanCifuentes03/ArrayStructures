import java.util.Scanner;

public class ArrayStructure {

    //Array properties
    private int [] theArray = new int[50];
    private int arraySize = 10;
   //========================================

    // method to create random values in the array
    public void generateRandomArray(){
        for (int i = 0; i< arraySize; i++){
            theArray[i] = (int)(Math.random()*10)+10;
        }
        System.out.println("--NEW ARRAY GENERATED--");
    }
    //========================================

    // Method tho print the array in a good way in the console
    public void printArray(){
        System.out.println("----------");
        for (int i = 0; i< arraySize; i++){
            System.out.print("| " + i + " | ");
            System.out.println(theArray[i] + " |");
            System.out.println("----------");

        }
    }
    //========================================

    //Method that returns the index value
    public int getValueAtIndex(int index){
        if(index < arraySize) return theArray[index];
        return 0;
    }
    //========================================

    // Method to know if a value is in an array
    public boolean doesArrayContainThisValue(int searchValue){
        boolean valueInArray = false;
        // for loop to verify if the value is in the array
        for (int i = 0; i < arraySize; i++){
            if(theArray[i] == searchValue){
                valueInArray = true;
            }
        }
        return  valueInArray;
    }
    //========================================

    // Method that deletes an index
    public void deleteIndex(int index){
        // we check if the index it's in the array
        if(index < arraySize){
            for(int i = index; i<(arraySize-1); i++){
                theArray[i] = theArray[i+1];
            }
            arraySize--;
        }
    }
    //========================================

    // Method that inserts values
    public void insertValue (int number){
        if(arraySize < 50){
            theArray[arraySize] = number;
            arraySize++;

        }
    }
    //========================================

    //
    public String linearSearchForValue(int value){
        boolean valueInArray = false;
        String indexsWithValue = "";
        System.out.print("The value " + value + " was found in the following index: ");
        for(int i = 0; i < arraySize; i++){
            if(theArray[i] == value){
                valueInArray = true;
                indexsWithValue+= i + " ";
            }
        }
        if(!valueInArray){
            indexsWithValue = "None";
        }
        System.out.println();
        return  indexsWithValue;
    }
    //========================================

    //The bubble sort will sort everything Ascending or descending
    public void bubbleSort(){
        // it starts from the end of the array
        // As it is decremented all indexes greater
        // than it, are sorted.
        for(int i = arraySize - 1; i > 1; i--){
            /*
            The inner loop starts at the beginning of the array and compares
            each value next to each other. If the value is grater then it swapped
             */
            for(int j = 0 ; j<i; j++){
                // you can change to descending changing ">" to "<".
                if(theArray[j] > theArray [j+1]){
                    int temp        = theArray[j + 1];
                    theArray[j + 1] = theArray[j];
                    theArray[j]     = temp;
                }

            }
        }
    }
    //========================================

    public void binarySearchForValue(int value){
        int lowIndex = 0;
        int highIndex = arraySize - 1;

    }


    public void menu(){
        System.out.println("----ARRAY STRUCTURE----");
        System.out.println("Options:" +
                "\n1. Generate array" +
                "\n2. Get value at index" +
                "\n3. Ask if the array contains a value" +
                "\n4. Delete an index" +
                "\n5. Insert a value" +
                "\n6. Linear Search for a value" +
                "\n7. Bubble sort" +
                "\n0. EXIT"
                        );
    }



    public static void main(String[] args) {
        int optionS             = 0;
        boolean doOption        = true;
        ArrayStructure newArray = new ArrayStructure();
        Scanner sc              = new Scanner(System.in);

        do{

            //===================================//
            newArray.menu();
            System.out.println("Enter an option: ");
            optionS = sc.nextInt();
            //===================================//

            switch (optionS){
                case 1:
                    newArray.generateRandomArray();
                    newArray.printArray();
                    break;
                case 2:
                    int valueSearch;
                    System.out.println("Enter the value your looking for: ");
                    valueSearch = sc.nextInt();
                    System.out.println(newArray.getValueAtIndex(valueSearch));
                    break;
                case 3:
                    int isValue;

                    System.out.println("Enter the number: ");
                    isValue = sc.nextInt();
                    System.out.println("is the number " + isValue + " in array?: " + newArray.doesArrayContainThisValue(isValue));

                    break;
                case 4:
                    int deletIndex;
                    System.out.println("What index do you want to delete: (from 0 to " + newArray.arraySize + " )");
                    deletIndex = sc.nextInt();
                    newArray.deleteIndex(deletIndex);
                    newArray.printArray();
                    break;
                case 5:
                    int newValue;
                    System.out.println("Enter the new value: ");
                    newValue = sc.nextInt();
                    newArray.insertValue(newValue);
                    newArray.printArray();
                    break;
                case 6 :
                    int linearSearchValue;
                    System.out.println("Linear search for a value, enter the value: ");
                    linearSearchValue = sc.nextInt();
                    System.out.println( newArray.linearSearchForValue(linearSearchValue));
                    break;
                case 7:
                    newArray.bubbleSort();
                    newArray.printArray();
                    break;
                case 0 :
                    doOption = false;
                    break;
                default:
                    System.out.println("This option does not exist. Try again");
                    break;
            }

        }while(doOption);
    }
}
