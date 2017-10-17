import {PaymentDetails} from "./PaymentDetails";
export class OrderDetails{
    orderId:number;
    orderDate:Date;
    finalPrice:number;
    paymentId:PaymentDetails;
}