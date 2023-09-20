package net.daum;

import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import net.daum.dao.BoardRepository;
import net.daum.vo.BoardVO;

@SpringBootTest
class Boot03ApplicationTests {

	@Autowired
	private BoardRepository boardRepo;
	
	@Test
	public void testInsertBoard20() {
		for(int i=1; i<=20; i++) {
			BoardVO b = new BoardVO();
			
			b.setWriter("user0"+ (i%10)); //글쓴이 저장
			b.setTitle("게시판 제목..:"+i); //글제목 저장
			b.setContent("게시판 내용..:"+i); //글내용 저장
			
			//this.boardRepo.save(b); //게시판 저장, this.은 생략 가능함.
		}
	}//20개 샘플 레코드 저장
	
	//쿼리 메서드에서 제목으로 검색
	@Test
	public void testByTitle() {
		//자바 8이전 방법
		/*List<BoardVO> blist = this.boardRepo.findBoardVOByTitle("게시판 제목..:7");
		
		if(blist != null && blist.size() > 0) {//검색된 레코드가 있는 경우
			for(int i=0; i<blist.size(); i++) {
				System.out.println(blist.get(i));
			}
		}else {
			System.out.println("검색된 자료가 없습니다!");
		}
	}//testByTitle() */
	
	//자바 8 이후 방법
	//this.boardRepo.findBoardVOByTitle("게시판 제목..:7")
	//.forEach(b->System.out.println(b));
	}//testByTitle()
	
	@Test
	public void testByWriter() {
		//System.out.println(" \n===========================> 글쓴이로 검색");
		//Collection<BoardVO> blist = this.boardRepo.findByWriter("user00");
		//blist.forEach(b->System.out.println(b)); //user00글쓴이 자료 검색
	}//testByWriter()
	
	@Test //글쓴이에서 05가 포함된 게시물 검색 => '%'+05+'%' like 검색
	public void testByWriterContaining() {
		//System.out.println(" \n============================>05글쓴이 like 검색");
		//Collection<BoardVO> blist = this.boardRepo.findByWriterContaining("05");
		//blist.forEach(b->System.out.println(b));
	}//testByWriterContaining()
	
	@Test //제목에 '2'가 포함되거나 내용에 '5'가 포함된 경우
	public void testByTitleOrContentContaining() {
		//System.out.println(" \n ========================>제목에 2가 포함되거나 내용에 5가 포함된 경우");
		//Collection<BoardVO> blist=
		//		this.boardRepo.findByTitleContainingOrContentContaining("2", "5");
		//blist.forEach(b->System.out.println(b));
	}//testByTitleOrContentContaining()
	
	@Test //제목에 '5'가 포함되어 있고 게시물 번호가 2보다 큰 자료 검색
	public void testByTitleAndBno() {
		//System.out.println(" \n ========================>제목에 5가 포함되어 있고 게시물 번호가 2보다 큰 자료 검색");
		//Collection<BoardVO> blist =
		//		this.boardRepo.findByTitleContainingAndBnoGreaterThan("5", 2);
		//blist.forEach(b->System.out.println(b));
	}//testByTitleAndBno()
	
	@Test //번호가 10보다 큰 자료를 내림차순 정렬
	public void testBnoOrderBy() {
		//System.out.println(" \n ====================>번호가 10보다 큰 게시물 내림차순 정렬");
		//Collection<BoardVO> blist=
		//		this.boardRepo.findByBnoGreaterThanOrderByBnoDesc(10);
		//blist.forEach(b->System.out.println(b));
	}//testBnoOrderBy()
	
	@Test //'제목'이 들어간 자료 검색
	public void testByTitle2() {
		//System.out.println(" \n ==================>제목이 들어간 자료 검색");
		//this.boardRepo.findByTitle("제목")
		//.forEach(b->System.out.println(b));
	}//testByTitle2()
	
	@Test //@Param 내용에 대한 검색 처리
	public void testByContent() {
		//System.out.println(" \n ==================>내용에 대한 검색처리:@Param");
		//this.boardRepo.findbyContent("내용")
		//.forEach(b->System.out.println(b));
	}//testByContent()
	
	@Test //원하는 컬럼만 검색
	public void testByTitle3() {
		System.out.println(" \n ==================>");
		this.boardRepo.findByTitle2("7")
		.forEach(arr->System.out.println(Arrays.toString(arr)));//반환된 배열을 문자열로
		//변환해서 출력
	}//testByTitle3()
	
}






