package com.sunlakka.explore.regex;

/*Strip the links and the text name from the html pages*/
public class DetectHTMLLinks {

	public static void main(String[] args) {
		
		runPartialPatternRegex();
	}
	
	private static void runPartialPatternRegex() {
		Scanner scanner = new Scanner(System.in);
        int noOfLines = Integer.parseInt(scanner.nextLine());
        if(noOfLines<100){
            int fragmentLength = 0;
            while(scanner.hasNext()){
                 String inputString = scanner.nextLine();
                 fragmentLength = fragmentLength + inputString.length();
                 if(fragmentLength<=10000){
                      Pattern p = Pattern.compile("<a\\shref=\"([^\"]++)");
                      Matcher m = p.matcher(inputString);
                      while(m.find()){
                          String link = m.group(1).trim();
                          String nextStr = inputString.substring(m.end()+1);
                          String text = nextStr.substring(nextStr.indexOf(">")+1,nextStr.indexOf("</a>")).replaceAll("<[^>]*>","").trim();
                          System.out.println(link+","+text);
                      }
                 }else
                      break;
            }
        }
        scanner.close(); 
		
	}
	
	private static void runFullPatternRegex() {
		Scanner scanner = new Scanner(System.in);
        int noOfLines = Integer.parseInt(scanner.nextLine());
        if(noOfLines<100){
            int fragmentLength = 0;
            while(scanner.hasNext()){
                 String inputString = scanner.nextLine();
                 fragmentLength = fragmentLength + inputString.length();
                 if(fragmentLength<=10000){
                	 Pattern p = Pattern.compile("<a\\shref=\"([^\"]++)\"([^<>]*)>(<\\w>)*([^<>]*)<");
                      Matcher m = p.matcher(inputString);
                      while(m.find()){
                    	  System.out.println(m.group(1).trim()+","+m.group(4).trim());
                      }
                 }else
                      break;
            }
        }
        scanner.close(); 
	}
}
