// 처음 풀이
// 처음 선택한 길이 끝까지 이어질 거라고 생각했던 잘못.. (막혀있을 수 있음..!)
// const solution = (tickets) => {
//   const ticketCount = tickets.length;
//   tickets.sort((a, b) => a[1] > b [1] ? 1 : -1);
//   const ans = [];

//   while(ans.length < ticketCount) {
//     const now = ans.length === 0 ? 'ICN' : ans[ans.length - 1];
//     const nextIdx = tickets.findIndex(ticket => ticket[0] === now);
//     const next = tickets.splice(nextIdx, 1);
//     ans.push(next[0][1]);
//   }
  
//   return ['ICN', ...ans];
// }

// J138_이광민님 생각 정리 도와주셔서 넘 감사합니다~!
const solution = (tickets) => {
  tickets.sort((a, b) => a[1] > b [1] ? 1 : -1);

  const ans = ['ICN'];
  const isVisited = Array(tickets.length).fill(false);
  const dfs = (now) => {
    for(let i = 0; i < tickets.length; i++) {
      if(!isVisited[i] && tickets[i][0] === now) {
        isVisited[i] = true;
        ans.push(tickets[i][1]);
        dfs(tickets[i][1]);
        if(ans.length === tickets.length + 1) {
          return;
        }
        isVisited[i] = false;
        ans.pop();
      }
    }
  }

  dfs('ICN');
  return ans;
}

const testcase = [
  { 'tickets': [["ICN", "JFK"], ["HND", "IAD"], ["JFK", "HND"]] },
  { 'tickets': [["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "ATL"], ["ATL", "ICN"], ["ATL", "SFO"]] },
];

testcase.forEach(({ tickets }) => {
  console.log(solution(tickets));
})