package com.calculator.calculator.backend;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class CalculatorController {

    @PostMapping("/calculate")
    public String calculate(@RequestBody String json) {

        try {
            JSONObject obj = new JSONObject(json);
            String expression = obj.getString("expression");
            System.out.println(expression);
            int t1=-1,t2=-1,t3=-1;
            for (int i = 0; i < expression.length(); i++) {
                if(expression.charAt(i)=='%')
                {
                    t1=i;
                    break;
                }
            }
            int y1=expression.indexOf("add");
            int y2=expression.indexOf("sub");
            int y3=expression.indexOf("multiply");
            int y4=expression.indexOf("div");


            if(y1!=-1||y2!=-1||y3!=-1||y4!=-1) {
                if (y1 != -1) {
                    String[] parts = expression.split("add");
                    double op1 = 0;

                    double op2 = 0;
                    if(parts.length>2)
                        return "E";

                    int p1=parts[0].indexOf("Inv");
                    int p2=parts[0].indexOf("pow(2)");
                    int p3=parts[0].indexOf("pow(0.5)");
                    int p4=parts[0].indexOf("%");
                    if(p1!=-1||p2!=-1||p3!=-1||p4!=-1)
                    {
                        if(p1!=-1&&p2==-1&&p3==-1&&p4==-1)
                        {
                            double op=Double.parseDouble(parts[0].substring(0,p1));
                            if(op==0)
                            {
                                return "E";
                            }
                           op1= Math.pow(op,-1);
                        }
                        else if(p2!=-1&&p1==-1&&p3==-1&&p4==-1)
                        {
                            double op=Double.parseDouble(parts[0].substring(0,p2));
                            op1= Math.pow(op,2);

                        }
                        else if(p3!=-1&&p1==-1&&p2==-1&&p4==-1)
                        {
                            double op=Double.parseDouble(parts[0].substring(0,p3));
                            if(op<0)
                                return "E";
                            op1= Math.pow(op,0.5);

                        }
                        else if (p4!=-1&&p1==-1&&p2==-1&&p3==-1) {

                            double op=Double.parseDouble(parts[0].substring(0,p4));
                            op1= op/100;

                        } else
                        {
                            return "E";
                        }


                    }
                    else
                    {
                         op1 = Double.parseDouble(parts[0]);

                    }




                    int p11=parts[1].indexOf("Inv");
                    int p22=parts[1].indexOf("pow(2)");
                    int p33=parts[1].indexOf("pow(0.5)");
                    int p44=parts[1].indexOf("%");
                    if(p11!=-1||p22!=-1||p33!=-1||p44!=-1)
                    {
                        if(p11!=-1&&p22==-1&&p33==-1&&p44==-1)
                        {
                            double op=Double.parseDouble(parts[1].substring(0,p11));
                            if(op==0)
                            {
                                return "E";
                            }
                            op2= Math.pow(op,-1);
                        }
                        else if(p22!=-1&&p11==-1&&p33==-1&&p44==-1)
                        {
                            double op=Double.parseDouble(parts[1].substring(0,p22));
                            op2= Math.pow(op,2);

                        }
                        else if(p33!=-1&&p11==-1&&p22==-1&&p44==-1)
                        {
                            double op=Double.parseDouble(parts[1].substring(0,p33));
                            if(op<0)
                                return "E";
                            op2= Math.pow(op,0.5);

                        }
                        else if (p44!=-1&&p11==-1&&p22==-1&&p33==-1) {

                            double op=Double.parseDouble(parts[1].substring(0,p44));
                            op2= op/100;
                        } else
                        {
                            return "E";
                        }


                    }
                    else
                    {
                        op2 = Double.parseDouble(parts[1]);

                    }













                    return Double.toString(op1 + op2);


                } else if (y2 != -1) {
                    String[] parts = expression.split("sub");
                    if(parts.length>2)
                        return "E";
                    double op1 = 0;

                    double op2 = 0;

                    int p1=parts[0].indexOf("Inv");
                    int p2=parts[0].indexOf("pow(2)");
                    int p3=parts[0].indexOf("pow(0.5)");
                    int p4=parts[0].indexOf("%");
                    if(p1!=-1||p2!=-1||p3!=-1||p4!=-1)
                    {
                        if(p1!=-1&&p2==-1&&p3==-1&&p4==-1)
                        {
                            double op=Double.parseDouble(parts[0].substring(0,p1));
                            if(op==0)
                            {
                                return "E";
                            }
                            op1= Math.pow(op,-1);
                        }
                        else if(p2!=-1&&p1==-1&&p3==-1&&p4==-1)
                        {
                            double op=Double.parseDouble(parts[0].substring(0,p2));
                            op1= Math.pow(op,2);

                        }
                        else if(p3!=-1&&p1==-1&&p2==-1&&p4==-1)
                        {
                            double op=Double.parseDouble(parts[0].substring(0,p3));
                            if(op<0)
                                return "E";
                            op1= Math.pow(op,0.5);

                        }
                        else if (p4!=-1&&p1==-1&&p2==-1&&p3==-1) {

                            double op=Double.parseDouble(parts[0].substring(0,p4));
                            op1= op/100;

                        } else
                        {
                            return "E";
                        }


                    }
                    else
                    {
                        op1 = Double.parseDouble(parts[0]);

                    }




                    int p11=parts[1].indexOf("Inv");
                    int p22=parts[1].indexOf("pow(2)");
                    int p33=parts[1].indexOf("pow(0.5)");
                    int p44=parts[1].indexOf("%");
                    if(p11!=-1||p22!=-1||p33!=-1||p44!=-1)
                    {
                        if(p11!=-1&&p22==-1&&p33==-1&&p44==-1)
                        {
                            double op=Double.parseDouble(parts[1].substring(0,p11));
                            if(op==0)
                            {
                                return "E";
                            }
                            op2= Math.pow(op,-1);
                        }
                        else if(p22!=-1&&p11==-1&&p33==-1&&p44==-1)
                        {
                            double op=Double.parseDouble(parts[1].substring(0,p22));
                            op2= Math.pow(op,2);

                        }
                        else if(p33!=-1&&p11==-1&&p22==-1&&p44==-1)
                        {
                            double op=Double.parseDouble(parts[1].substring(0,p33));
                            if(op<0)
                                return "E";
                            op2= Math.pow(op,0.5);

                        }
                        else if (p44!=-1&&p11==-1&&p22==-1&&p33==-1) {

                            double op=Double.parseDouble(parts[1].substring(0,p44));
                            op2= op/100;
                        } else
                        {
                            return "E";
                        }


                    }
                    else
                    {
                        op2 = Double.parseDouble(parts[1]);

                    }











                    return Double.toString(op1 - op2);
                } else if (y3 != -1) {
                    String[] parts = expression.split("multiply");
                    if(parts.length>2)
                        return "E";
                    double op1 = 0;

                    double op2 = 0;

                    int p1=parts[0].indexOf("Inv");
                    int p2=parts[0].indexOf("pow(2)");
                    int p3=parts[0].indexOf("pow(0.5)");
                    int p4=parts[0].indexOf("%");
                    if(p1!=-1||p2!=-1||p3!=-1||p4!=-1)
                    {
                        if(p1!=-1&&p2==-1&&p3==-1&&p4==-1)
                        {
                            double op=Double.parseDouble(parts[0].substring(0,p1));
                            if(op==0)
                            {
                                return "E";
                            }
                            op1= Math.pow(op,-1);
                        }
                        else if(p2!=-1&&p1==-1&&p3==-1&&p4==-1)
                        {
                            double op=Double.parseDouble(parts[0].substring(0,p2));
                            op1= Math.pow(op,2);

                        }
                        else if(p3!=-1&&p1==-1&&p2==-1&&p4==-1)
                        {
                            double op=Double.parseDouble(parts[0].substring(0,p3));
                            if(op<0)
                                return "E";
                            op1= Math.pow(op,0.5);

                        }
                        else if (p4!=-1&&p1==-1&&p2==-1&&p3==-1) {

                            double op=Double.parseDouble(parts[0].substring(0,p4));
                            op1= op/100;

                        } else
                        {
                            return "E";
                        }


                    }
                    else
                    {
                        op1 = Double.parseDouble(parts[0]);

                    }




                    int p11=parts[1].indexOf("Inv");
                    int p22=parts[1].indexOf("pow(2)");
                    int p33=parts[1].indexOf("pow(0.5)");
                    int p44=parts[1].indexOf("%");
                    if(p11!=-1||p22!=-1||p33!=-1||p44!=-1)
                    {
                        if(p11!=-1&&p22==-1&&p33==-1&&p44==-1)
                        {
                            double op=Double.parseDouble(parts[1].substring(0,p11));
                            if(op==0)
                            {
                                return "E";
                            }
                            op2= Math.pow(op,-1);
                        }
                        else if(p22!=-1&&p11==-1&&p33==-1&&p44==-1)
                        {
                            double op=Double.parseDouble(parts[1].substring(0,p22));
                            op2= Math.pow(op,2);

                        }
                        else if(p33!=-1&&p11==-1&&p22==-1&&p44==-1)
                        {
                            double op=Double.parseDouble(parts[1].substring(0,p33));
                            if(op<0)
                                return "E";
                            op2= Math.pow(op,0.5);

                        }
                        else if (p44!=-1&&p11==-1&&p22==-1&&p33==-1) {

                            double op=Double.parseDouble(parts[1].substring(0,p44));
                            op2= op/100;
                        } else
                        {
                            return "E";
                        }


                    }
                    else
                    {
                        op2 = Double.parseDouble(parts[1]);

                    }











                    return Double.toString(op1 * op2);

                } else {
                    String[] parts = expression.split("div");
                    if(parts.length>2)
                        return "E";
                    double op1 = 0;

                    double op2 = 0;

                    int p1=parts[0].indexOf("Inv");
                    int p2=parts[0].indexOf("pow(2)");
                    int p3=parts[0].indexOf("pow(0.5)");
                    int p4=parts[0].indexOf("%");
                    if(p1!=-1||p2!=-1||p3!=-1||p4!=-1)
                    {
                        if(p1!=-1&&p2==-1&&p3==-1&&p4==-1)
                        {
                            double op=Double.parseDouble(parts[0].substring(0,p1));
                            if(op==0)
                            {
                                return "E";
                            }
                            op1= Math.pow(op,-1);
                        }
                        else if(p2!=-1&&p1==-1&&p3==-1&&p4==-1)
                        {
                            double op=Double.parseDouble(parts[0].substring(0,p2));
                            op1= Math.pow(op,2);

                        }
                        else if(p3!=-1&&p1==-1&&p2==-1&&p4==-1)
                        {
                            double op=Double.parseDouble(parts[0].substring(0,p3));
                            if(op<0)
                                return "E";
                            op1= Math.pow(op,0.5);

                        }
                        else if (p4!=-1&&p1==-1&&p2==-1&&p3==-1) {

                            double op=Double.parseDouble(parts[0].substring(0,p4));
                            op1= op/100;

                        } else
                        {
                            return "E";
                        }


                    }
                    else
                    {
                        op1 = Double.parseDouble(parts[0]);

                    }




                    int p11=parts[1].indexOf("Inv");
                    int p22=parts[1].indexOf("pow(2)");
                    int p33=parts[1].indexOf("pow(0.5)");
                    int p44=parts[1].indexOf("%");
                    if(p11!=-1||p22!=-1||p33!=-1||p44!=-1)
                    {
                        if(p11!=-1&&p22==-1&&p33==-1&&p44==-1)
                        {
                            double op=Double.parseDouble(parts[1].substring(0,p11));
                            if(op==0)
                            {
                                return "E";
                            }
                            op2= Math.pow(op,-1);
                        }
                        else if(p22!=-1&&p11==-1&&p33==-1&&p44==-1)
                        {
                            double op=Double.parseDouble(parts[1].substring(0,p22));
                            op2= Math.pow(op,2);

                        }
                        else if(p33!=-1&&p11==-1&&p22==-1&&p44==-1)
                        {
                            double op=Double.parseDouble(parts[1].substring(0,p33));
                            if(op<0)
                                return "E";
                            op2= Math.pow(op,0.5);

                        }
                        else if (p44!=-1&&p11==-1&&p22==-1&&p33==-1) {

                            double op=Double.parseDouble(parts[1].substring(0,p44));
                            op2= op/100;
                        } else
                        {
                            return "E";
                        }


                    }
                    else
                    {
                        op2 = Double.parseDouble(parts[1]);

                    }










                    if(op2==0)
                        return "E";
                    return Double.toString(op1 / op2);
                }


            }



            if(t1!=-1)
            {

                if(t1!=0&&t1==expression.length()-1)
                {
                    String q="";
                    for (int i = 0; i < expression.length()-1; i++) {
                        q=q+expression.charAt(i);

                    }
                    double x= Double.parseDouble(q);
                    x=x/100;
                    return Double.toString(x);
                }
                else
                {
                    return "E";
                }
            }



            int p1=expression.indexOf("Inv");
             int p2=expression.indexOf("pow(2)");
             int p3=expression.indexOf("pow(0.5)");
             if(p1!=-1||p2!=-1||p3!=-1)
             {
                 if(p1!=-1&&p2==-1&&p3==-1)
                 {
                    double op=Double.parseDouble(expression.substring(0,p1));
                    if(op==0)
                    {
                        return "E";
                    }
                    return Double.toString(Math.pow(op,-1));
                 }
                 else if(p2!=-1&&p1==-1&&p3==-1)
                 {
                     double op=Double.parseDouble(expression.substring(0,p2));
                     return Double.toString(Math.pow(op,2));

                 }
                 else if(p3!=-1&&p1==-1&&p2==-1)
                 {
                     double op=Double.parseDouble(expression.substring(0,p3));
                     if(op<0)
                         return "E";
                     return Double.toString(Math.pow(op,0.5));

                 }


             }

            if(y1==-1&&y2==-1&&y3==-1&&y4==-1&&p1==-1&&p2==-1&&p3==-1&&t1==-1)
            {

               int q=expression.indexOf("-");
               if(q==-1)
               {
                   return expression;
               }

             if(q>1)
             {
                 return "E";
             }
             else
             {
                 if(expression.equals(" -")||expression.equals("-"))
                 {
                     return "E";
                 }
                 else  {
                     for (int i = 0; i < expression.length(); i++) {
                         if(expression.charAt(i)==' ')
                         {
                             if(i>2)
                             {
                                 return "E";
                             }
                         }
                     }

                 }


                     return expression;
             }

            }

            return "E";

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getMessage());
            return "E"; // Handle exceptions and return an error code
        }
    }
}