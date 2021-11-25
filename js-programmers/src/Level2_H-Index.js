// const solution = (citations) => {
//   const dsc = citations.sort((a, b) => b - a);

//   let remain = dsc.length;
//   let ans = 0;
//   for(let i = 1; i <= (dsc.length < dsc[0] ? dsc.length : dsc[0]); i++) {
//     const cur = dsc[remain - 1];
//     if(cur < i) {
//       remain--;
//     }
//     if(remain >= i) {
//       ans = i;
//     } else {
//       break;
//     }
//   }
//   return ans;
// }

// 왜 이렇게 생각을 못했을까..
const solution = (citations) => {
  const dsc = citations.sort((a, b) => b - a);

  let i = 0;
  while(i + 1 <= dsc[i]) {
    i++
  }
  
  return i;
}

const testcase = [
  { 'ciations': [3, 0, 6, 1, 5] },
  { 'ciations': [1, 1, 1, 1, 2, 2] },
  { 'ciations': [3] },
];

testcase.forEach(({ ciations }) => {
  console.log(solution(ciations));
})