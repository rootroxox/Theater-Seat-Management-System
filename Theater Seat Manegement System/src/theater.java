import java.util.Scanner;

public class theater {

    public static void main(String[] args) {

        int[] rowS = {1,2,3,4,5,6,7,8};
        int rows = '1';
        String [][] arr = {{"[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"},{"[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"},
                {"[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"},{"[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"},
                {"[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"},{"[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"},
                {"[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"},{"[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"}};

        welcome();
        System.out.println();
        System.out.println();
        System.out.println("1 - Show Seats");
        System.out.println("2 - Make a reservation");
        System.out.println("3 - Delete a reservation");
        System.out.println("4 - Exit");
        System.out.print("What is your choice: ");
        int choice;
        Scanner scan = new Scanner(System.in);
        choice = scan.nextInt();

        switch (choice)
        {
            case 1:
                showSeats(rows,arr,rowS);
            case 2:
                getSeat(rows,arr,rowS);
            case 3:
                delSeat(rows,arr,rowS);
            case 4:
                System.exit(0);
        }
        scan.close();
    }

    public static void showSeats(int rows, String[][] arr,int[] rowS){
        System.out.println("\t\t         1    2    3    4    5    6    7    8    9    10   11   12");


        for (int i = 0; i < 8; ++i)
        {
            System.out.print("\t\t    " +rowS[i]+ ":  ");
            ++rows;
            for (int j = 0; j < 12; ++j)
                System.out.print(arr[i][j] + "  ");
            System.out.println();
        }

        System.out.println("Do you want to make a reservation ? 'Y' or 'N'");
        String decision;
        Scanner scan = new Scanner(System.in);
        decision = scan.nextLine();
        if(decision.equals("y")||decision.equals("Y")){
            getSeat(rows,arr,rowS);
        }
        else if(decision.equals("n")||decision.equals("N")){
            System.out.println();
            System.out.println();
            System.out.println("1 - Show Seats");
            System.out.println("2 - Make a reservation");
            System.out.println("3 - Delete a reservation");
            System.out.println("4 - Exit");
            System.out.print("What is your choice: ");

            int choice;
            choice = scan.nextInt();

            switch (choice)
            {
                case 1:
                    showSeats(rows,arr,rowS);
                case 2:
                    getSeat(rows,arr,rowS);
                case 3:
                    delSeat(rows,arr,rowS);
                case 4:
                    System.exit(0);

            }
        }
        scan.close();
    }

    public static void welcome(){
        System.out.println("\t\t################################################");
        System.out.println("\t\t#\t\t\t\t\t\t\t\t\t\t\t   #");
        System.out.println("\t\t#\t\t\t\t\t\t\t\t\t\t\t   #");
        System.out.println("\t\t#\t\t\t\t\t\t\t\t\t\t\t   #");
        System.out.println("\t\t#\t\tWelcome to Seat Management System      #");
        System.out.println("\t\t#\t\t\t\t\t\t\t\t\t\t\t   #");
        System.out.println("\t\t#\t\t\t\t\t\t\t\t\t\t\t   #");
        System.out.println("\t\t#\t\t\t\t\t\t\t\t\t\t\t   #");
        System.out.println("\t\t################################################");
        try
        {
            System.out.println("3...");
            Thread.sleep(1000);
            System.out.println("2...");
            Thread.sleep(1000);
            System.out.println("1...");
            Thread.sleep(1000);
        }
        catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

    }

    public static void delSeat(int rows, String[][] arr,int[] rowS){
        Scanner scan = new Scanner(System.in);
        int input;
        int row;
        int col;
        for (input = 1; input < 97; input = input + 2)
        {
            rows = '1';
            System.out.println();
            System.out.print("\t\t               Enter Row & Column: ");
            row = scan.nextInt();
            col = scan.nextInt();

            if ((row <= 0 || row >= 9) || (col <= 0 || col >= 13))
            {
                System.out.println();
                System.out.print("\t\t              Please Pick A Valid Seat");
                System.out.println();
                try
                {
                    Thread.sleep(1000);
                }
                catch(InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }

                showSeats(rows,arr,rowS);
            }
            --row;
            --col;
            if (arr[row][col].equals("[ ]"))
            {
                System.out.println();
                System.out.print("\t\t             Seat is Already Empty");
                System.out.println();

            }
            arr[input][input + 1] = arr[row][col];
            arr[row][col] = "[ ]";
            System.out.println();
            System.out.print("\t\t            1   2   3   4   5   6   7   8   9   10  11  12");
            System.out.println();
            for (int i = 0; i < 8; ++i)
            {
                System.out.print("\t\t    " + rowS[i] + ":    ");
                ++rows;
                for (int j = 0; j < 12; ++j)
                    System.out.print(arr[i][j] + " ");
                System.out.println();
            }
            System.out.println();
            System.out.print("\t\t                   Seat Deleted");
            System.out.println();

            System.out.println();
            System.out.print("\t\t        Do You Want To Delete Another Seat?");
            System.out.println();

            System.out.println();
            System.out.print("\t\t          Press [1] For Yes & [2] For No.");
            System.out.println();

            System.out.print("\t\t                        ");

            int chocie1;
            chocie1 = scan.nextInt();

            if (chocie1==1) {
                delSeat(rows,arr,rowS);
            }
            else if (chocie1==2){
                System.out.println();
                System.out.println();
                System.out.println("1 - Show Seats");
                System.out.println("2 - Make a reservation");
                System.out.println("3 - Delete a reservation");
                System.out.println("4 - Exit");
                System.out.print("What is your choice: ");

                int choice;
                choice = scan.nextInt();

                switch (choice)
                {
                    case 1:
                        showSeats(rows,arr,rowS);
                    case 2:
                        getSeat(rows,arr,rowS);
                    case 3:
                        delSeat(rows,arr,rowS);
                    case 4:
                        System.exit(0);
                }
            }

        }
        scan.close();
    }

    public static void getSeat(int rows, String[][] arr,int[] rowS){
        Scanner scan = new Scanner(System.in);
        int input;
        int row;
        int col;
        for (input = 1; input < 97; input = input + 2)
        {
            rows = '1';
            System.out.println();
            System.out.print("\t\t               Enter Row & Column: ");
            row = scan.nextInt();
            col = scan.nextInt();

            if ((row <= 0 || row >= 9) || (col <= 0 || col >= 13))
            {
                System.out.println();
                System.out.print("\t\t              Please Pick A Valid Seat");
                System.out.println();
                try
                {
                    Thread.sleep(1000);
                }
                catch(InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }

                showSeats(rows,arr,rowS);
            }
            --row;
            --col;
            if (arr[row][col].equals("X"))
            {
                System.out.println();
                System.out.print("\t\t             Seat Not Available");
                System.out.println();
                getSeat(rows,arr,rowS);
            }
            arr[input][input + 1] = arr[row][col];
            arr[row][col] = "[X]";

            System.out.println();
            System.out.print("\t\t            1   2   3   4   5   6   7   8   9   10  11  12");
            System.out.println();
            for (int i = 0; i < 8; ++i)
            {
                System.out.print("\t\t    " + rowS[i] + ":    ");
                ++rows;
                for (int j = 0; j < 12; ++j)
                    System.out.print(arr[i][j] + " ");
                System.out.println();
            }

            System.out.println();
            System.out.print("\t\t                   Seat Booked!");
            System.out.println();

            System.out.println();
            System.out.print("\t\t        Do You Want To Book Another Seat?");
            System.out.println();

            System.out.println();
            System.out.print("\t\t          Press [1] For Yes & [2] For No.");
            System.out.println();

            System.out.print("\t\t                        ");

            int choice1;
            choice1 = scan.nextInt();

            if (choice1==1) {
                getSeat(rows,arr,rowS);
            }
            else if (choice1==2){
                System.out.println();
                System.out.println();
                System.out.println("1 - Show Seats");
                System.out.println("2 - Make a reservation");
                System.out.println("3 - Delete a reservation");
                System.out.println("4 - Exit");
                System.out.print("What is your choice: ");

                int choice;
                choice = scan.nextInt();

                switch (choice)
                {
                    case 1:
                        showSeats(rows,arr,rowS);
                    case 2:
                        getSeat(rows,arr,rowS);
                    case 3:
                        delSeat(rows,arr,rowS);
                    case 4:
                        System.exit(0);

                }
            }
        }
        scan.close();
    }
}
