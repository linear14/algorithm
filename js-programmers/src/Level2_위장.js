// 최초풀이
// const solution = (clothes) => {
//   const map = clothes.reduce((pre, cur) => {
//     const type = cur[1];
//     pre.set(type, pre.has(type) ? pre.get(type) + 1 : 1);
//     return pre;
//   }, new Map())

//   return Array.from(map.values()).reduce((pre, cur) => pre * (cur + 1), 1) - 1;
// }

// 개선 (cur[0] 은 의미가 없기 때문에 더 줄일 수 있을 것 같음)
const solution = (clothes) => {
  return Object.values(clothes
  .map(item => item[1])
  .reduce((pre, cur) => {
    pre[cur] = pre[cur] ? pre[cur] + 1 : 1;
    return pre;
  },{}))
  .reduce((pre, cur) => pre * (cur + 1), 1) - 1;
}

const testData = [
  [["yellowhat", "headgear"], ["bluesunglasses", "eyewear"], ["green_turban", "headgear"]],
  [["crowmask", "face"], ["bluesunglasses", "face"], ["smoky_makeup", "face"]]
]
  
testData.forEach((clothes) => {
  console.log(solution(clothes));
})