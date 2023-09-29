import { Sidebar, TextInput } from "flowbite-react";

import type { FC } from "react";
import { useEffect, useState } from "react";
import {
  HiLogin,
  HiSearch,
  HiUsers,
} from "react-icons/hi";

const ExampleSidebar: FC = function () {
  const [currentPage, setCurrentPage] = useState("");

  useEffect(() => {
    const newPage = window.location.pathname;

    setCurrentPage(newPage);
  }, [setCurrentPage]);

  return (
    <Sidebar aria-label="Sidebar with multi-level dropdown example">
      <div className="flex h-full flex-col justify-between py-2">
        <div>
          <form className="pb-3 md:hidden">
            <TextInput
              icon={HiSearch}
              type="search"
              placeholder="Search"
              required
              size={32}
            />
          </form>
          <Sidebar.Items>
            <Sidebar.ItemGroup>
              <Sidebar.Item
                href="/"
                icon={HiUsers}
                className={
                  "/" === currentPage
                    ? "bg-gray-100 dark:bg-gray-700"
                    : ""
                }
              >
                Clientes
              </Sidebar.Item>
            </Sidebar.ItemGroup>

            <Sidebar.ItemGroup>

              <Sidebar.Item href="/login" icon={HiLogin}>
                Sair
              </Sidebar.Item>

            </Sidebar.ItemGroup>
          </Sidebar.Items>
        </div>
      </div>
    </Sidebar>
  );
};

export default ExampleSidebar;
