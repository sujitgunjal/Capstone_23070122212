class Order{
    int orderId;
    String customerType;
    double orderValue;
    int deliveryTime;
    Order( int orderId, String customerType, double orderValue, int deliveryTime){
        this.orderId = orderId;
        this.customerType = customerType;
        this.orderValue = orderValue;
        this.deliveryTime = deliveryTime;
    }

}
public class SIT_203 {
    public static void main(String[] args) {
        Order[] order = {
                new Order(101, "Regular", 500.0, 5),
                new Order(102, "Prime", 200.0, 3),
                new Order(103, "Prime", 700.0, 2),
                new Order(104, "Regular", 500.0, 2),
                new Order(105, "Prime", 700.0, 2)
        };
        mergeSort(order, 0, order.length - 1);
    }

    static void mergeSort(Order[] order, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(order, left, mid);
            mergeSort(order, mid + 1, right);
            merge(order, left, mid, right);

        }
    }

    static void merge(Order[] order, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        Order[] leftArray = new Order[n1];
        Order[] rightArray = new Order[n2];

        for (int i = 0; i < n1; i++) {
            leftArray[i] = order[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = order[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i].customerType.equals("Prime") && rightArray[j].customerType.equals("Regular")) {
                order[k++] = leftArray[i++];
            } else if (leftArray[i].customerType.equals("Regular") && rightArray[j].customerType.equals("Prime")) {
                order[k++] = rightArray[j++];
            } else {
                if (leftArray[i].orderValue > rightArray[j].orderValue) {
                    order[k++] = leftArray[i++];
                } else if (leftArray[i].orderValue < rightArray[j].orderValue) {
                    order[k++] = rightArray[j++];
                } else {
                    if (leftArray[i].deliveryTime < rightArray[j].deliveryTime) {
                        order[k++] = leftArray[i++];
                    } else {
                        order[k++] = rightArray[j++];
                    }
                }
            }
        }
        while (i < n1) {
            order[k++] = leftArray[i++];
        }
        while (j < n2) {
            order[k++] = rightArray[j++];
        }
    }
}