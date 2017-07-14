package assignment1;
// 
public class OctalConverter {
	
		int binaryToOctal(int binum)
		{
			int temp=0;
			try
			{int no=binum;
				
				while(no>0){
				if(no%10!=1 | no%10!=0)
				{
					throw new Exception();
				}
				no=no/10;
				}
			}
			catch(Exception e)
			{

	System.out.println("wrong Input");
		}
			
			int dnum=0;
			int flag=1;
			int octnum=0;
			while(binum!=0)
			{
				temp=binum%10;
				dnum=dnum+temp*flag;
				binum=binum/10;
			
				flag=flag*2;
			}
			
			temp=0;
			flag=1;
			while(dnum>0)
			{ 
			temp=dnum%8;
			octnum=octnum+temp*flag;
			dnum=dnum/8;
			flag=flag*10;
			}
			return octnum;
			}

			
			

			
			
		
}

