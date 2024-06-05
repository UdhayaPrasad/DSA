
class Sorting {

    static void ss(int[] arr) {
        int min;
        for (int i = 0; i < arr.length; i++) {
            min = i;
            for (int j = i + 1; j < arr.length; j++) {

                if (arr[j] < arr[min]) {
                    min = j;
                }

            }

            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;

        }
    }

    public static void insertionSort(int arr[], int n) {
        int key, j;
        for (int i = 1; i < n; i++) {
            key = arr[i];
            j = i - 1;

            while (j >= 0 && arr[j] > key) {

                arr[j + 1] = arr[j];
                j--;

            }

            arr[j + 1] = key;
        }
    }

    static void bs(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    static int part(int[] arr, int s, int e) {

        int pivot = arr[e];
        int i = s - 1;
        for (int j = s; j <= e - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[e];
        arr[e] = temp;

        return (i + 1);

    }

    static void qs(int[] arr, int s, int e) {

        if (s < e) {
            int pi = part(arr, s, e);
            qs(arr, s, pi - 1);
            qs(arr, pi + 1, e);
        }

    }

    static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void mergesort(int[] arr, int beg, int end) {
        if (beg < end) {
            int mid = (beg + end) / 2;
            mergesort(arr, beg, mid); // left subarray
            mergesort(arr, mid + 1, end); // right subarray
            merge(arr, beg, end, mid);
        }
    }

    public static void merge(int[] arr, int beg, int end, int mid) {

        int n1 = mid - beg + 1; // left subarray size
        int n2 = end - mid;

        int[] leftsubarr = new int[n1];
        int[] rightsubarr = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftsubarr[i] = arr[beg + i];

        }

        for (int j = 0; j < n2; j++) {
            rightsubarr[j] = arr[mid + 1 + j];
        }

        /* Sorting Process */

        int i = 0, j = 0, k = beg;
        while (i < n1 && j < n2) {

            if (leftsubarr[i] <= rightsubarr[j]) {
                arr[k] = leftsubarr[i];
                i++;
            }

            else {
                arr[k] = rightsubarr[j];
                j++;
            }

            k++;
        }

        while (i < n1) {
            arr[k] = leftsubarr[i];
            i++;
            k++;

        }

        while (j < n2) {
            arr[k] = rightsubarr[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 24, 4, 77, 33, 2 };

        System.out.println("SS sort:");
        ss(arr);
        print(arr);

        System.out.println("Bs Sort :");

        bs(arr);
        print(arr);

        System.out.println("Qs sort:");
        qs(arr, 0, arr.length - 1);
        print(arr);

        System.out.println("Ms Sort:");
        mergesort(arr, 0, arr.length - 1);
        print(arr);

        System.out.println("Is Sort:");
        insertionSort(arr, arr.length - 1);
        print(arr);

    }
}