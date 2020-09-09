"""
연결 리스트라는 형태의 자료 구조에서 palindrome 판별하기
val 로 해당 값을 가져오고 뒤의 값은 next로 불러올 수 있음

https://leetcode.com/problems/palindrome-linked-list/
"""

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        q = list()

        node = head
        while node is not None:
            q.append(node.val)
            node = node.next
            
        if q == q[::-1]:
            return True
        else:
            return False