package ex_240426;

public class BookTest {

    public static void main(String[] args) {
        // Book 인스턴스 3개 만들어주세요
    	// 웹 구조
    	// 책등록 - 관리자 - 제목,저자,가격,출판사 등
    	// 화면에서 입력을 받음. DTO 데이터 전잗ㄹ하는 클래스 담아서 전달
    	// 백엔드 DTO 클래스 하나, 책 한권의 정보랑 동일
    	// DTO 정보를 DB에 넣기
    	
    	// 정의한 생성자의 매개변수 순서로 작성
        Book book1 = new Book("Name1", "Author1", 10000);
        Book book2 = new Book("Name2", "Author2", 20000);
        Book book3 = new Book("Name3", "Author3", 30000);

        // Book 3개를 받는 배열도 만들어주세요
        Book[] bookArray = new Book[3];

        // 배열에 담아서 반복문으로 출력해주세요
        // 추가로 반복문으로 넣는 방법 모색.
        // 1) new 를 이용해서
        // 2) 메서드를 만들어서..?
        bookArray[0] = book1;
        bookArray[1] = book2;
        bookArray[2] = book3;

        for (int i = 0; i < bookArray.length; i++) {
            System.out.println("Book " + (i + 1) + ":");
            System.out.println("Name: " + bookArray[i].getBookName());
            System.out.println("Author: " + bookArray[i].getBookAuthor());
            System.out.println("Price: " + bookArray[i].getBookPrice());
            System.out.println();
            
//            Book receiveBook;
//            receiveBook=bookArray[i];
//            String resultString =receiveBook.toString();
//            System.out.println(resultString);
        }
    }
}

