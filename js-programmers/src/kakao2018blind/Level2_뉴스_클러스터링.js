const solution = (str1, str2) => {
  str1 = str1.toUpperCase();
  str2 = str2.toUpperCase();
  
  const obj1 = getMulObject(str1);
  const obj2 = getMulObject(str2);

  const ic = getIntersectionCount(obj1, obj2);
  const uc = getUnionCount(obj1, obj2);
  
  return Math.floor(65536 * (uc === 0 ? 1 : ic / uc));
}

const getMulObject = (str) => {
  return str.split('').reduce((pre, _, idx) => {
      if(idx !== str.length - 1) {
          const [l1, l2] = [str[idx], str[idx + 1]];
          if(l1 >= 'A' && l1 <= 'Z' && l2 >= 'A' && l2 <= 'Z') {
              const key = l1 + l2;
              pre[key] = (key in pre) ? pre[key] + 1 : 1;
          }
      }
      return pre;
  }, {});
}

const getIntersectionCount = (obj1, obj2) => {
  const obj1keys = Object.keys(obj1);
  return obj1keys.reduce((pre, key) => {
      if(obj2[key]) return pre + Math.min(obj1[key], obj2[key]);
      return pre;
  }, 0)
}

const getUnionCount = (obj1, obj2) => {
  const obj1keys = Object.keys(obj1);
  const obj2keys = Object.keys(obj2);

  const keys = [...new Set([...obj1keys, ...obj2keys])];
  return keys.reduce((pre, key) => {
      if(obj1[key]) {
          if(obj2[key]) {
              return pre + Math.max(obj1[key], obj2[key]);
          }
          else {
              return pre + obj1[key];
          }
      }
      return pre + obj2[key];
  }, 0);
  
}