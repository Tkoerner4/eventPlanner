public class testin
{
    private int sort (int[] arr)
    {
        int i=0;
        int j =0;
        int smallest_index=0;//smallest val in unsorted part
        int temp_val=0; // stores object that will be moved
        for(i=0;i<arr.length;i++)// goes thru arr
        {
            smallest_index=i;// smallest index is default at beginning of unsorted part
            for(j =i+1;j< arr.length;j++)// starts after the end of the unsorted, starting on the first unsorted val
            {
                if(arr[j]<arr[smallest_index])// if the number being examined is less than the current smallest
                {// then theyre swapped
                    smallest_index=j;
                }
            }
            //after the unsorted part is completely examined
            temp_val=arr[i]; //temp is set to the first unsorted number
            arr[i] = arr[smallest_index];//the first unsorted number is set to the smallest of the unsorted, making it sorted
            arr[smallest_index] = temp_val;// the spot where the smallest entry was formerly is replaced with the previous first sunroted number
        }
        return arr;
    }
    public static void main(String[] args)
    {

        int[] arr = [4,3,6,9,2];
        arr= sort(arr);
    }
}
