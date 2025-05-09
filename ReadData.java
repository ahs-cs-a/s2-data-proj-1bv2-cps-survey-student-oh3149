import java.util.Scanner;
import java.io.File;


public class ReadData{
    //I hard-coded the number of rows and columns so 
    //I could use a 2D array
    private double[][] data = new double[21908][14];
    //This should read in the csv file and store the data in a 2D array,
    //data -- don't forget to skip the header line and parse everything
    //as doubles  
    public void read(){
        try{
            Scanner scanner = new Scanner(new File("cps.csv"));
            int row = 0;
            scanner.nextLine(); // Skip the header line
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] lineArr = line.split(",");
                for(int col = 0; col < lineArr.length; col++){
                    data[row][col] = Double.parseDouble(lineArr[col]);
                }
                row++;
            }
            scanner.close();
    
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    //this should return the column of data based
    //on the column number passed in -- the column number
    //is 0 indexed, so the first column is 0, the second
    //is 1, etc.
    //this should return a double array of the column
    //of data
    public double[][] getColumns(int col1, int col2){
        double[][] columns = new double[data.length][col2-col1];
        for(int row = 0; row < data.length; row++){
            for(int col = col1; col < col2; col++){
                columns[row][col-col1] = data[row][col];
            }
        }
        return columns;
    }

    //this returns the standard deviation of the x and y column
    //of data passed in
    //the standard deviation is the square root of the variance
    //the variance is the sum of the squares of the differences
    //between each value and the mean, 
    //divided by the number of values - 1(sample variance)
    //Use Math.pow to square the difference
    //and Math.sqrt to take the square root
    //return an array with two values -- standard deviation 
    //for the x column and y column
    public double[] stdDeviation(double[][] xy){
        double sum = 0;
        double[] mean = ...
        ...
        return .. //sample variance!
    }
    
    //this returns the mean of each columns of data passed in
    //the mean is the sum of the values divided by the number 
    //of values
    public double[] mean(double[][] xy){
        double[] mean = new double[xy.length];
        for(int x = 0; x < xy.length; x++){
            for(int row = 0; row < xy.length; row++){
                double sum = 0;
                for(int col = 0; col < xy[row].length; col++){
                    sum += xy[row][col];
                }
                mean[x] = sum / xy[row].length;
            }
        }
        return mean;
    }

    //this returns the values of each column in standard units
    //the standard units are the value minus the mean divided by the standard deviation
    //this should return a double 2D array of the standard units
    public double[][] standardUnits(double[][] xy){
        double[][] stdArr = ...
        double[] stdDeviation = ...;
        double[] mean = ...;
        ...
        return stdArr;
    }
    
    //this returns the correlation between the two columns of data passed in
    //the correlation is the sum of the products of the standard units
    //of the two columns divided by the number of values - 1
    //this should return a double
    //the correlation is a measure of the strength of the linear relationship
    //between the two columns of data
    //the correlation is between -1 and 1
    public double correlation(double[][] xy){
        double sum = 0;
        ...
        return ...;    
    }
    
    public void runRegression(){
        // double[][] xy = getColumns(7,9);
        // double[][] xyStd = standardUnits(xy);
        // double correlation = correlation(xyStd);
        // double slope = correlation * xyStd[1] / xyStd[0];
        // double[] means = mean(xy)
        // double intercept = means[1] - slope * means[0];
        // System.out.println("Correlation: " + correlation);
        // System.out.println("Slope: " + slope);
        // System.out.println("Intercept: " + intercept);
        // Scatter s = new Scatter();
        // s.displayScatterPlot(xy[0], xy[1]);
    }

    //this prints the array passed in - you may want this for debugging
    public void print(double[][] arr){
        for(int row = 0; row < arr.length; row++){
            for(int col = 0; col < arr[row].length; col++){
                System.out.print(arr[row][col] + " ");
            }
            System.out.println();
        }
        
    }
    public static void main(String[] args) {
        ReadData rd = new ReadData();
        rd.read();
        rd.runRegression();
    }

}
