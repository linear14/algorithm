class Node {
  constructor(value, prev = null, next = null) {
    this.value = value;
    this.prev = prev;
    this.next = next;
  }
}

class LRUCache {
  constructor(maxSize) {
    this.head = null;
    this.tail = null;
    this.maxSize = maxSize;
    this.length = 0;
    this.cachedItem = new Set();
  }

  append(value) {
    const newNode = new Node(value);

    // 캐시 최대 용량이 0이라면
    if(this.maxSize === 0) {
      return 5;
    }

    // 이미 캐시된 항목이 있다면
    if(this.cachedItem.has(value)) {
      this.delete(value);
      this.append(value);
      return 1;
    }

    // 캐시가 비어있다면
    if(!this.head) {
      this.head = newNode;
      this.tail = newNode;
      this.length++;
      this.cachedItem.add(value);
      return 5;
    }

    // 캐시가 꽉 차있다면
    if(this.maxSize === this.length) {
      this.delete(this.head.value);
      this.append(value);
      return 5;
    }
  
    // 나머지 경우 (비어있는 것도 아니고 꽉 차있는 것도 아닌 경우)
    this.tail.next = newNode;
    newNode.prev = this.tail;
    this.tail = newNode;
    this.length++;
    this.cachedItem.add(value);
    return 5;
  }

  delete(value) {
    // 한 개 이상 들어있어야 삭제 가능
    if(this.head) {
      let now = this.head;

      while(now) {
        if(now.value === value) {
          this.cachedItem.delete(value);

          if(now === this.head) {
            if(now.next) now.next.prev = null;
            this.head = now.next;
          }
          else if(now === this.tail) {
            now.prev.next = null;
            this.tail = now.prev;
          }
          else {
            now.prev.next = now.next;
            now.next.prev = now.prev;
          }
          this.length--;
          return;
        }
        now = now.next;
      }
      return;
    }
  }
}

const solution = (cacheSize, cities) => {
  const cache = new LRUCache(cacheSize);
  return cities.reduce((pre, city) => pre + cache.append(city.toUpperCase()), 0);
}

// 런타임 에러로 날만한게 뭐가 있을까..
const testData = [
  // { cacheSize	: 3, cities: ["Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"] },
  // { cacheSize	: 3, cities: ["Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"] },
  // { cacheSize	: 2, cities: ["Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"] },
  // { cacheSize	: 5, cities: ["Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"] },
  // { cacheSize	: 2, cities: ["Jeju", "Pangyo", "NewYork", "newyork"] },
  // { cacheSize	: 0, cities: ["Jeju", "Pangyo", "Seoul", "NewYork", "LA"] },
  // { cacheSize	: 3, cities: ["A", "B", "A", "C"] },
  // { cacheSize	: 0, cities: ["A", "B", "A", "C"] },
  { cacheSize	: 1, cities: ["A", "B", "A", "C"] },
  { cacheSize	: 1, cities: ["A", "A", "A", "C"] },
  { cacheSize	: 2, cities: ["A", "A", "A", "C"] },
  { cacheSize	: 3, cities: ["A", "A", "A", "C"] },
];

testData.forEach(({ cacheSize, cities }) => {
  console.log(solution(cacheSize, cities));
});