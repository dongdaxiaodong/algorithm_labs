## 项目流程

1. 聚合random set
    1. 两部分，一是city,二是path
    2. city(id,name)
    3. path(id,startCity,endCity,cost)
    4. 随机算法: city使用国际城市名称,路径应该保证每个city有两个path
2. 获取输入，进行random
3. 使用brute force算法求解哈密尔顿回路问题


1. The algorithm that you have used:
    1. i use breadth-first search algorithm to achieve hamiltonian path
2. i name a data structures graph to implement my breadth-first search,graph have a LinkedList 
    consist of City, and another linkedList consist of path.
3. 