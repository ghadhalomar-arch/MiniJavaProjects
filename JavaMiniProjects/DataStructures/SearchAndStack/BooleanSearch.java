import java.util.Arrays;

public class BooleanSearch {
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid; // found
            } else if (arr[mid] < target) {
                left = mid + 1; // search right half
            } else {
                right = mid - 1; // search left half
            }
        }
        return -1; // not found
    }
}
// Binary search for linked list
    public Node binarySearch(int target) {
        Node start = head;
        Node end = null;

        while (start != end) {
            Node mid = getMiddle(start, end);

            if (mid.data == target)
                return mid;
            else if (mid.data < target)
                start = mid.next;
            else
                end = mid;
        }
        return null; // not found
    }
