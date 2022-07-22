const solution = (s) => {
  const arr = [];
  
  for(let i = 0; i < s.length; i++) {
      const item = s[i];
      if(item === '(') {
          arr.push('(');
      }
      else {
          const last = arr[arr.length - 1];
          if(last === '(') {
              arr.pop();
          }
          else {
              return false;
          }
      }
  }

  return arr.length ? false : true;
}