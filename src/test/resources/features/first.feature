Feature: Начальный тест для изучения Cucumber

  Scenario: Простой тест без тела

  Scenario: Простой тест с Given
    Given открыт браузер

  Scenario: Простой тест с Given и When
    Given открыт браузер
    When страница логина открыта

  Scenario: Простой тест со всеми ключевыми словами
    Given открыт браузер
    When страница логина открыта
    Then поле username отображается при запуске

  Scenario: Использование AND в Given
    Given открыт браузер
    And страница логина открыта

  Scenario: Использование AND в Given
    Given открыт браузер
    And страница логина открыта
    Then поле username отображается при запуске