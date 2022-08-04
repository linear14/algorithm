// 끝나는 위치 기준으로 오름차순
// 0번 index부터 끝나는 위치에 포함되는 모든 element들 n개 제거
// 이후 n번 index부터 반복
// 반복 횟수가 정답이 됨
const solution = (routes) => {
  let ans = 0;
  let curIdx = 0;
  const sorted = routes.sort((a, b) => a[1] === b[1] ? a[0] - b[1] : a[1] - b[1]);
  
  while(curIdx < routes.length) {
      const endPoint = sorted[curIdx][1];
      curIdx++;

      while(curIdx < routes.length && sorted[curIdx][0] <= endPoint && sorted[curIdx][1] >= endPoint) {
       curIdx++;   
      }
      ans++;
  }
  
  return ans;
}