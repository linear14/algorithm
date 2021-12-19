const solution = (n, arr1, arr2) => {
  const ans = Array.from({ length: n }, () => Array(n).fill(' '));
  
  arr1 = arr1.map(i => parseBinaryString(n, i));
  arr2 = arr2.map(i => parseBinaryString(n, i));
  
  for(let i = 0; i < n; i++) {
      for(let j = 0; j < n; j++) {
          if(arr1[i][j] !== '0' || arr2[i][j] !== '0') {
              ans[i][j] = '#';
          }
      }
  }

  return ans.map(arr => arr.join(''));
}

const parseBinaryString = (n, num) => {
  if(num === 0) { return ''.padStart(n, '0') }
  
  const s = [];
  while(num !== 1) {
      s.push(num % 2);
      num = Math.floor(num / 2);
  }
  s.push(1);
  
  return s.reverse().join('').padStart(n, '0');
}