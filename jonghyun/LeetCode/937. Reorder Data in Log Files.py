"""
리스트 원소를 정렬하는 문제

https://leetcode.com/problems/reorder-data-in-log-files/submissions/

"""

class Solution:
    def reorderLogFiles(self, logs: List[str]) -> List[str]:
        letters, digits = [], []
        
        for log in logs:
            if log.split()[1].isdigit():
                digits.append(log)
            else:
                letters.append(log)
        
        # 원하는 순서로 정렬하기 위해서. 문제의 조건에서 가장 앞 단어는 상관 없으나 모든 문자가 동일한 경우에 순서를 따진다는 조건이 있기 때문에 맨 뒤에 넣어줌 
        letters.sort(key=lambda x: (x.split()[1:], x.split()[0]))
        
        # 리스트 오브젝트 리턴 시 순서를 정의해주는 부분
        return letters + digits