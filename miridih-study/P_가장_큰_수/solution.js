const solution = (numbers) => {
  // 요거 안넣으면 '0000'을 그대로 내보내기 때문에 틀림
  // 그럼 number 으로 바꾼다음 또 string으로 바꾸면 되지 않음? ㄴㄴ안됨 숫자가 엄청 크기때문에 다른 testcase에서 틀리게 됨
  if(numbers.filter(num => num === 0).length === numbers.length) return '0';
  return numbers
      .sort((a, b) => `${b}${a}` - `${a}${b}`)
      .reduce((ans, num) => ans + num, '');
}