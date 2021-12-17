// const solution = (number, k) => {
//   const arr = number.split('');
//   let fromBack = false;

//   while(k-- > 0) {
//     if(fromBack) {
//       arr.splice(arr.length - 1, 1);
//     }
//     else {
//       for(let i = 0; i < arr.length; i++) {
//         if(i === arr.length - 1) { 
//           fromBack = true;
//           k++;
//         }
//         else if(arr[i] < arr[i + 1]) {
//           arr.splice(i, 1);
//           break;
//         }
//       }
//     }
//   }
//   return arr.join('');
// }

const solution = (number, k) => {
  const s = [];
  for(let i = 0; i < number.length; i++) {
    const now = number[i];
    while(k > 0 && s[s.length - 1] < now) {
      s.pop();
      k--;
    }
    s.push(now);
  }
  return s.slice(0, s.length - k).join('');
}


const testcase = [
  { 'number': "1924", 'k': 2 },
  { 'number': "1231234", 'k': 3 },
  { 'number': "4177252841", 'k': 4 },
  { 'number': "4177252841", 'k': 6 },
];

testcase.forEach(({ number, k }) => {
  console.log(solution(number, k));
})