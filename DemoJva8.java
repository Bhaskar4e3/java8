package newtasks;

import java.util.Arrays;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.Set;
import java.util.StringJoiner;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.List;

public class DemoJva8 {
    public static void main(String[] args) {
        Integer[] arr={1,2,3,4,5,6};
       OptionalDouble arrResult= Arrays.stream(arr).
                                mapToInt(Integer::valueOf).average();
                                System.out.println(arrResult.getAsDouble());
      ////////////////////////////////////////////////////////////////
      String str="java jj"  ;
     Map<Character,Long> mapStr= str.chars().mapToObj(m->(char)m).collect
                  (Collectors.groupingBy(Function.identity(),LinkedHashMap::new,
                        Collectors.counting())) ;
                        mapStr.forEach((k,v)->System.out.println(k+"::"+v));
            Optional<Character> first_Non_repeat= mapStr.entrySet().stream().
                          filter(p->p.getValue()==1).map(l->l.getKey()).findFirst();
                          System.out.println(first_Non_repeat.get()); 
                          
      Optional<Character> first_repeat =mapStr.entrySet().stream().
                       filter(f->f.getValue()>1).map(a->a.getKey()).findFirst() ;
                       System.out.println(first_repeat.get()); 
               ///////////////////////////////////////////////////////////
            List<Integer> list=Arrays.asList(2,3,4,5,6,7,4,3); 
            Set<Integer> s=new HashSet<>();  
           list.stream().filter(m->!s.add(m)).forEach(System.out::println);  
           list.stream().distinct().forEach(System.out::println);    
            HashSet<Integer> hashset=(HashSet<Integer>) list.stream()
                   .collect(Collectors.toSet());
           System.out.println(hashset); 
             ////////////////////////////////////////////////////////////
             List<Integer> list1=Arrays.asList(2,3,4,5,6);
             int sum=list1.stream().mapToInt(Integer::valueOf).sum();
        OptionalInt max= list1.stream().mapToInt(Integer::valueOf).max();
       OptionalInt min=  list1.stream().mapToInt(Integer::valueOf).min();
       OptionalDouble avg=list1.stream().mapToInt(Integer::valueOf).average();
       System.out.println(sum);
        System.out.println((double)max.getAsInt());
     System.out.println(min.getAsInt());
     System.out.println((int)avg.getAsDouble());
     //////////////////////////////////////////////////////////////
    List<String> lstr=Arrays.asList("rob","smith","","smith","mad","rob","","smith");
    Map<String,Long> maplstr= lstr.stream().filter(m->m.equals(""))
                .collect(Collectors.groupingBy
             (Function.identity(),LinkedHashMap::new,Collectors.counting()));
         maplstr.forEach((k,v)->System.out.println(k+":::"+v)); 
         
         List<String> lstr1=Arrays.asList("rob","smith","","smith","mad","rob","","smith");
 System.out.println(lstr1.stream().filter(p->p.equals("")).count());
 ///////////////////////////////////////////////////////////
 String strorg="java is a language";
   for(int i=strorg.length()-1;i>=0;i--){
    System.out.print(strorg.charAt(i));}
    System.out.println();
    ///////////or////////////
    StringBuilder sb=new StringBuilder();
    for(char c:strorg.toCharArray()){
               sb.append(c);
    }
    String revStrorg= sb.reverse().toString();
    System.out.println(revStrorg);
    ///////////////////////////////////////////////
    String sk="bhaskar";
    String sk1="ak";
    String sk2="bk";
   StringJoiner sj=new StringJoiner("--","[","]");
   sj.add(sk).add(sk1).add(sk2);
   System.out.println(sj.toString());
   ////////////////////////////////////////////////////////////////////
   String strcode="java is a coding";
   System.out.println(String.valueOf('d'));
   Integer i=20;
   System.out.println(i.getClass());
   String revstrcode= Stream.of(strcode).
             map(bh->new StringBuffer(strcode).reverse()).
             collect(Collectors.joining(strcode));
             System.out.println(revstrcode);
             ///////////or/////
      String strcode1="java is a coding1"; 
     String revstrcode2= strcode1.chars().mapToObj(ch->String.valueOf((char)ch)).
                     reduce((ch1,ch2)->(ch2+ch1)).orElse("");
                     System.out.println(revstrcode2);
  // //////////////////////////////////////////////////////////////////
         Map<Character,Long> mapStrcode=strcode1.chars().mapToObj(m->(char)m).
             collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting())) ;           
       Optional<Character> firstNONRepeat=mapStrcode.entrySet().stream().
    filter(m->m.getValue()==1).map(m->m.getKey()).findFirst();
    System.out.println(firstNONRepeat.get());
    System.out.println();
    Optional<Character> firstRepeat=mapStrcode.entrySet().stream().
    filter(s1->s1.getValue()>1).map(s1->s1.getKey()).findFirst();
    System.out.println(firstRepeat.get());
///////////////////////////////////////////////////////////////////////////
String string1="a3b4c2";//aaabbbbcc
  StringBuilder stringBuilder=new StringBuilder();
  for(int k=0;k<string1.length();k++){
  if(Character.isDigit(string1.charAt(k))){
        for(int l=0;l<Character.getNumericValue(string1.charAt(k))-1;l++){
          stringBuilder.append(string1.charAt(k-1));
        }
  }
  else{
    stringBuilder.append(string1.charAt(k));
  }
  }
  System.out.println(stringBuilder.toString());
  
  /////////////////reverse for above aaabbbbcc=a3b4c2/////////
  String string2="aaabbbbcc";///a3b4c2
  Map<Character,Long> mapstring2=string2.chars().mapToObj(cha->(char)cha).
               collect(Collectors.groupingBy
               (Function.identity(),LinkedHashMap::new,Collectors.counting()));
        System.out.println(mapstring2);  
      StringBuilder sBuilder1=new StringBuilder();
      for(Entry<Character, Long> e:mapstring2.entrySet()){
            sBuilder1.append(e.getKey());
            sBuilder1.append(e.getValue());
      }
      System.out.println(sBuilder1.toString());
      /////////////////////////////////////////////////////
      String string3="java is coding";
       long targetChar= string3.chars().filter(o->o=='a').count();
       System.out.println(targetChar);
       //////////////////////////////////////////////////////////////////
       String sr="java is coding language";
    String revSr=sr.chars().mapToObj(st->String.valueOf((char)st)).
    reduce((s1,s2)->s2+s1).orElse("");
    System.out.println(revSr);
      //////////////////////or///////////////////
     String revSR= Stream.of(sr).map(srt-> new StringBuilder(srt).reverse()).
      collect(Collectors.joining());
      System.out.println(revSR);
//////////////////////////////////////////////////////////////////
String value="java is hard to learn";
String charToStr=String.valueOf('a');
System.out.println(charToStr.getClass());
////////////////////////////////////////////////////////
int num=456723;
     int resultSum=   Stream.of(String.valueOf(num).split("")).
        collect(Collectors.summingInt(Integer::valueOf));
        System.out.println(resultSum);
  ////////////////////////////
   IntSummaryStatistics summaryStatistics=  Stream.of(String.valueOf(num).split("")).
           collect(Collectors.summarizingInt(Integer::valueOf));
           System.out.println(summaryStatistics);
      ////////////////////////////////////////////////
      Integer abc=new Integer(10) ;
      int b=10;
      System.out.println(abc);    
  }
}