# 결과
| 메모리(KB) | 시간(ms) | 비고 |
| :---: | :---: | :-- |
| 9488 | 156 |  | 
| 9484 | 164 |  |

# 과정
## 자바스크립트에는 특정 문자의 Character Code를 알 수 없을까?
자바에서는 char 자료형이 따로 존재하고, 해당 자료형은 문자의 유니코드 값으로 변환하여 저장하기 때문에 이런 문제를 풀 때 쉽게 접근 가능했던 기억이 있다.  
자바스크립트에서는 char 자료형이 따로 없기 때문에, 처음에는 문자를 input으로 받아 idx를 output으로 리턴해주는 mapper를 하나 만들어 접근했다. 하지만, 분명 유니코드로 변환해주는 함수가 존재할 것 같아서 알아봤더니 `charCodeAt(idx)`라는 함수가 있었다. `Returns the Unicode value of the character at the specified location.`