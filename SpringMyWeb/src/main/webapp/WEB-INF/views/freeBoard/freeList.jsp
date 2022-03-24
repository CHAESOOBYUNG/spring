<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

    <section>
        <div class="container-fluid">
            <div class="row">
                <!--lg에서 9그리드, xs에서 전체그리드-->   
                <div class="col-lg-9 col-xs-12 board-table">
                    <div class="titlebox">
                        <p>자유게시판</p>
                    </div>
                    <hr>
                    
                    <!--form select를 가져온다 -->
                    <!-- 1. 검색처리란, pageNum=1, amount=10으로 다시세팅을 해서 검색키워드에 따른 조회 
                    	 2. 필요한 값을 hidden으로 처리해서 freeList로 전송
                    	 3. getList, getTotal을 동적쿼리로 변경
                    	 4. 페이지네이션을 누를 때 검색키워드를 전달하도록 처리
                    	 5. 검색한 키워드를 화면에 보여지도록 처리
                    -->
                    <form action="freeList">
                    
		    		<div class="search-wrap">
		    			<span>전체게시글 수: ${pageVO.total}</span>
		    			
                       <button type="submit" class="btn btn-info search-btn">검색</button>
                       <input type="text" class="form-control search-input" name="searchName" value="${pageVO.cri.searchName }">
                                              
                       <select class="form-control search-select" name="searchType">
                            <option value="title" ${pageVO.cri.searchType eq 'title' ? 'selected' : '' }>제목</option>
                            <option value="content" ${pageVO.cri.searchType eq 'content' ? 'selected' : '' }>내용</option>
                            <option value="writer" ${pageVO.cri.searchType eq 'writer' ? 'selected' : ''}>작성자</option>
                            <option value="titcont" ${pageVO.cri.searchType eq 'titcont' ? 'selected' : ''}>제목+내용</option>
                       </select>
                       
                       <input type="hidden" name="pageNum" value="1">
                       <input type="hidden" name="amount" value="${pageVO.cri.amount }">
                    </div>
                    
		    		</form>
                   
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>번호</th>
                                <th class="board-title">제목</th>
                                <th>작성자</th>
                                <th>등록일</th>
                                <th>수정일</th>
                            </tr>
                        </thead>
                        <tbody>
                        
                        	<c:forEach var="vo" items="${list }">
                            <tr>
                                <td>${vo.bno }</td>
                                <td><a href="freeDetail?bno=${vo.bno }">${vo.title }</a></td>
                                <td>${vo.writer }</td>
                                <td>
                                	<fmt:formatDate value="${vo.regdate }" pattern="yy년 MM월 dd일 hh시 mm분 ss초"/>
                                </td>
                                <td>
                                	<fmt:formatDate value="${vo.updatedate }" pattern="yyyy-MM-dd"/>
                                </td>
                            </tr>
                            </c:forEach>
                            
                        </tbody>
                        
                    </table>


                    <!--페이지 네이션을 가져옴-->
		    <form>
                    <div class="text-center">
                    <hr>
                    
                    <ul class="pagination pagination-sm">
                    
                    	<c:if test="${pageVO.prev }">
                        <li><a href="freeList?pageNum=${pageVO.startPage - 1 }&amount=${pageVO.amount}&searchType=${pageVO.cri.searchType }&searchName=${pageVO.cri.searchName }">이전</a></li>
                        </c:if>
                        
                        <c:forEach var="num" begin="${pageVO.startPage }" end="${pageVO.endPage }">
                        <li class="${pageVO.pageNum == num ? 'active' : '' }">
                        	<a href="freeList?pageNum=${num }&amount=${pageVO.amount}&searchType=${pageVO.cri.searchType }&searchName=${pageVO.cri.searchName }">${num }</a>
                        </li>
                        </c:forEach>
                        
                        <c:if test="${pageVO.next }">
                        	<li><a href="freeList?pageNum=${pageVO.endPage + 1 }&amount=${pageVO.amount}&searchType=${pageVO.cri.searchType}&searchName=${pageVO.cri.searchName }">다음</a></li>
                        </c:if>
                    </ul>
                    
                    <button type="button" class="btn btn-info" onclick="location.href='freeRegist'">글쓰기</button>
                    </div>
		    </form>

                </div>
            </div>
        </div>
	</section>
	
	<script>
		//메시지 처리
		var msg = '${msg}';
		if(msg != '') {
			alert(msg);
		}
	
	</script>



